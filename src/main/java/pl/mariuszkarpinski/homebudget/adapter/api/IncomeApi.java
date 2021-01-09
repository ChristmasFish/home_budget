package pl.mariuszkarpinski.homebudget.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mariuszkarpinski.homebudget.domain.Income;
import pl.mariuszkarpinski.homebudget.domain.port.CreateIncomeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/incomes")
@RequiredArgsConstructor
class IncomeApi {

    private final CreateIncomeService createIncomeService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<CreateIncomeResponse> createIncome(@Valid @RequestBody CreateIncomeRequest requestBody) {
        Income income = createIncomeService.create(requestBody.toDomain());
        return ResponseEntity.ok(new CreateIncomeResponse(income.getId()));
    }

}
