package pl.mariuszkarpinski.homebudget.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mariuszkarpinski.homebudget.domain.port.CreateIncome;
import pl.mariuszkarpinski.homebudget.domain.port.CreateIncomeService;
import pl.mariuszkarpinski.homebudget.domain.port.IncomeRepository;

@Service
@RequiredArgsConstructor
class CreateIncomeUseCase implements CreateIncomeService {

    private final IncomeRepository incomeRepository;

    @Override
    public Income create(CreateIncome createIncome) {
        Income income = new Income(
                createIncome.getName(),
                createIncome.getAmount(),
                createIncome.getDate());

        incomeRepository.save(income);

        return income;
    }

}
