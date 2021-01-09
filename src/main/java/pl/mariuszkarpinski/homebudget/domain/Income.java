package pl.mariuszkarpinski.homebudget.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "income")
@NoArgsConstructor
@Getter
public class Income {

    @Id
    private UUID id;
    private String name;
    private BigDecimal amount;
    private LocalDate date;

    private LocalDateTime createdDate;

    public Income(String name, BigDecimal amount, LocalDate date) {
        Assert.notNull(name, "name cannot be null");
        Assert.notNull(amount, "amount cannot be null");
        Assert.notNull(date, "date cannot be null");

        this.id = UUID.randomUUID();
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.createdDate = LocalDateTime.now();
    }

}
