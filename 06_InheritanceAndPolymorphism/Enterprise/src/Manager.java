import conditions.BonusSetting;
import conditions.PayBet;

public class Manager implements Employee {

    private Company company;
    private Double salary;

    public Manager(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    @Override
    public Double getSalary() {
        return salary;
    }


    @Override
    public Double getMonthSalary() {
        return PayBet.MANAGER.getBet() * getTimeWorkedPerMonth() +
                company.getIncome() * BonusSetting.MANAGER.getBonusAmount();
    }
}