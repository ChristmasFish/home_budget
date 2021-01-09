package pl.mariuszkarpinski.homebudget.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mariuszkarpinski.homebudget.domain.port.CreateExpense;
import pl.mariuszkarpinski.homebudget.domain.port.CreateExpenseService;
import pl.mariuszkarpinski.homebudget.domain.port.ExpenseRepository;

@Service
@RequiredArgsConstructor
class CreateExpenseUseCase implements CreateExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public Expense create(CreateExpense createExpense) {
        Expense expense = new Expense(
                createExpense.getName(),
                createExpense.getAmount(),
                createExpense.getDate()
        );

        expenseRepository.save(expense);

        return expense;
    }
}
