package pl.mariuszkarpinski.homebudget.adapter.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import pl.mariuszkarpinski.homebudget.domain.Expense;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class GetExpensesListResponse {

    private final List<GetExpenseData> data;
    private final Integer size;

    public GetExpensesListResponse(List<Expense> expenses) {
        this.data = expenses.stream().map(this::convertToData).collect(Collectors.toList());
        this.size = expenses.size();
    }

    private GetExpenseData convertToData(Expense expense) {
        return GetExpenseData.builder()
                .id(expense.getId())
                .name(expense.getName())
                .amount(expense.getAmount().toPlainString())
                .date(expense.getDate())
                .build();
    }

    @Value
    @Builder
    public static class GetExpenseData {

        UUID id;
        String name;
        String amount;
        LocalDate date;

    }

}
