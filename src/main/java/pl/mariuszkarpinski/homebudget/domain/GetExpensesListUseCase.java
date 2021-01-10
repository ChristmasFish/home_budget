package pl.mariuszkarpinski.homebudget.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mariuszkarpinski.homebudget.domain.port.ExpenseRepository;
import pl.mariuszkarpinski.homebudget.domain.port.GetExpensesListService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetExpensesListUseCase implements GetExpensesListService {

    private final ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getExpenses(LocalDate fromDate, LocalDate toDate) {
        return expenseRepository.findAllByDateBetween(fromDate, toDate);
    }
}
