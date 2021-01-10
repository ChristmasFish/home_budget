package pl.mariuszkarpinski.homebudget.domain.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mariuszkarpinski.homebudget.domain.Income;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface IncomeRepository extends JpaRepository<Income, UUID> {
    List<Income> findAllByDateBetween(LocalDate fromDate, LocalDate toDate);
}
