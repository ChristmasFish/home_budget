package pl.mariuszkarpinski.homebudget.domain.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mariuszkarpinski.homebudget.domain.Expense;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
    List<Expense> findAllByDateBetween(LocalDate fromDate, LocalDate toDate);
}
