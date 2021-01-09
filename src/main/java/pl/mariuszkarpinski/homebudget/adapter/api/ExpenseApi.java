package pl.mariuszkarpinski.homebudget.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mariuszkarpinski.homebudget.domain.Expense;
import pl.mariuszkarpinski.homebudget.domain.port.CreateExpenseService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
class ExpenseApi {

    private final CreateExpenseService createExpenseService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<CreateExpenseResponse> createExpense(@Valid @RequestBody CreateExpenseRequest requestBody) {
        Expense expense = createExpenseService.create(requestBody.toDomain());
        return ResponseEntity.ok(new CreateExpenseResponse(expense.getId()));
    }

}
