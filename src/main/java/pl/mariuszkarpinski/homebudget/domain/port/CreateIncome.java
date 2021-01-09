package pl.mariuszkarpinski.homebudget.domain.port;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CreateIncome {
    String getName();
    BigDecimal getAmount();
    LocalDate getDate();
}
