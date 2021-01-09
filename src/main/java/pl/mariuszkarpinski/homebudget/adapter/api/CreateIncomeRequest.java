package pl.mariuszkarpinski.homebudget.adapter.api;

import lombok.Builder;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;
import pl.mariuszkarpinski.homebudget.domain.port.CreateIncome;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@Builder
public class CreateIncomeRequest {

    @NotBlank
    private String name;

    @Positive
    @NotNull
    private BigDecimal amount;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    public CreateIncome toDomain() {
        return new CreateIncome() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public BigDecimal getAmount() {
                return amount;
            }

            @Override
            public LocalDate getDate() {
                return date;
            }
        };
    }
}
