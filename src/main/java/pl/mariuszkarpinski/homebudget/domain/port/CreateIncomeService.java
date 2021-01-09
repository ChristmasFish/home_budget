package pl.mariuszkarpinski.homebudget.domain.port;

import pl.mariuszkarpinski.homebudget.domain.Income;

public interface CreateIncomeService {

    Income create(CreateIncome createIncome);

}
