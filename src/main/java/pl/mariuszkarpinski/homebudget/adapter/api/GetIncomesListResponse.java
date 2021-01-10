package pl.mariuszkarpinski.homebudget.adapter.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import pl.mariuszkarpinski.homebudget.domain.Income;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class GetIncomesListResponse {

    private final List<GetIncomeData> data;
    private final Integer size;

    public GetIncomesListResponse(List<Income> incomes) {
        this.data = incomes.stream().map(this::convertToData).collect(Collectors.toList());
        this.size = incomes.size();
    }

    private GetIncomeData convertToData(Income income) {
        return GetIncomeData.builder()
                .id(income.getId())
                .name(income.getName())
                .amount(income.getAmount().toPlainString())
                .date(income.getDate())
                .build();
    }

    @Value
    @Builder
    public static class GetIncomeData {

        UUID id;
        String name;
        String amount;
        LocalDate date;

    }

}
