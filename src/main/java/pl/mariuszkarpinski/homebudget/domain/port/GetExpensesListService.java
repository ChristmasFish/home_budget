package pl.mariuszkarpinski.homebudget.domain.port;

import pl.mariuszkarpinski.homebudget.domain.Expense;

import java.time.LocalDate;
import java.util.List;

public interface GetExpensesListService {

    List<Expense> getExpenses(LocalDate fromDate, LocalDate toDate);

}
