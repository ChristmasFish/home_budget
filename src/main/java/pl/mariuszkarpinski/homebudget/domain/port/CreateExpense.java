package pl.mariuszkarpinski.homebudget.domain.port;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CreateExpense {
    String getName();
    BigDecimal getAmount();
    LocalDate getDate();
}
