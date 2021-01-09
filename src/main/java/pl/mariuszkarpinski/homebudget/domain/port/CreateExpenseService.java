package pl.mariuszkarpinski.homebudget.domain.port;

import pl.mariuszkarpinski.homebudget.domain.Expense;

public interface CreateExpenseService {

    Expense create(CreateExpense createExpense);

}
