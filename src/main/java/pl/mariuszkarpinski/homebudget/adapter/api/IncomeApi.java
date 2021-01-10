package pl.mariuszkarpinski.homebudget.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mariuszkarpinski.homebudget.domain.Income;
import pl.mariuszkarpinski.homebudget.domain.port.CreateIncomeService;
import pl.mariuszkarpinski.homebudget.domain.port.GetIncomesListService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/incomes")
@RequiredArgsConstructor
class IncomeApi {

    private final CreateIncomeService createIncomeService;
    private final GetIncomesListService getIncomesListService;
    private final DataRangeResolver dataRangeResolver;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<CreateIncomeResponse> createIncome(@Valid @RequestBody CreateIncomeRequest requestBody) {
        Income income = createIncomeService.create(requestBody.toDomain());
        return ResponseEntity.ok(new CreateIncomeResponse(income.getId()));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetIncomesListResponse> getIncomesList(
            @RequestParam(defaultValue = "CURRENT_MONTH") DataRange range,
            @RequestParam(required = false) LocalDate fromDate,
            @RequestParam(required = false) LocalDate toDate) {
        Pair<LocalDate, LocalDate> dates = dataRangeResolver.resolve(range, fromDate, toDate);
        List<Income> incomes = getIncomesListService.getIncomes(dates.getFirst(), dates.getSecond());
        GetIncomesListResponse response = new GetIncomesListResponse(incomes);

        return ResponseEntity.ok(response);
    }

}
