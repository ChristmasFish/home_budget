package pl.mariuszkarpinski.homebudget.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mariuszkarpinski.homebudget.domain.port.GetIncomesListService;
import pl.mariuszkarpinski.homebudget.domain.port.IncomeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetIncomesListUseCase implements GetIncomesListService {

    private final IncomeRepository incomeRepository;

    @Override
    public List<Income> getIncomes(LocalDate fromDate, LocalDate toDate) {
        return incomeRepository.findAllByDateBetween(fromDate, toDate);
    }
}
