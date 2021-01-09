package pl.mariuszkarpinski.homebudget.adapter.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class CreateIncomeResponse {

    @NotNull
    private final UUID id;

}
