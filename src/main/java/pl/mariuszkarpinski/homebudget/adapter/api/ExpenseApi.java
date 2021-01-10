package pl.mariuszkarpinski.homebudget.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mariuszkarpinski.homebudget.domain.Expense;
import pl.mariuszkarpinski.homebudget.domain.port.CreateExpenseService;
import pl.mariuszkarpinski.homebudget.domain.port.GetExpensesListService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
class ExpenseApi {

    private final CreateExpenseService createExpenseService;
    private final GetExpensesListService getExpensesListService;
    private final DataRangeResolver dataRangeResolver;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<CreateExpenseResponse> createExpense(@Valid @RequestBody CreateExpenseRequest requestBody) {
        Expense expense = createExpenseService.create(requestBody.toDomain());
        return ResponseEntity.ok(new CreateExpenseResponse(expense.getId()));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetExpensesListResponse> getExpensesList(
            @RequestParam(defaultValue = "CURRENT_MONTH") DataRange range,
            @RequestParam(required = false) LocalDate fromDate,
            @RequestParam(required = false) LocalDate toDate) {
        Pair<LocalDate, LocalDate> dates = dataRangeResolver.resolve(range, fromDate, toDate);
        List<Expense> expenses = getExpensesListService.getExpenses(dates.getFirst(), dates.getSecond());
        GetExpensesListResponse response = new GetExpensesListResponse(expenses);

        return ResponseEntity.ok(response);
    }

}
