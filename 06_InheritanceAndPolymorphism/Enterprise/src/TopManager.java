import conditions.BonusSetting;
import conditions.PayBet;

public class TopManager implements Employee {

    private Company company;
    private Double salary;

    public TopManager(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    @Override
    public Double getSalary() {
        return this.salary;
    }

    @Override
    public Double getMonthSalary() {
        if (company.getIncome() > 10000000.00)
            return PayBet.TOP_MANAGER.getBet() * getTimeWorkedPerMonth() +
                    company.getIncome() * BonusSetting.TOP_MANAGER.getBonusAmount();
        return PayBet.TOP_MANAGER.getBet() * getTimeWorkedPerMonth();
    }
}