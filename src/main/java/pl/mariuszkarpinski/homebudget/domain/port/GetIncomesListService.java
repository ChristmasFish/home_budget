package pl.mariuszkarpinski.homebudget.domain.port;

import pl.mariuszkarpinski.homebudget.domain.Income;

import java.time.LocalDate;
import java.util.List;

public interface GetIncomesListService {

    List<Income> getIncomes(LocalDate fromDate, LocalDate toDate);

}
