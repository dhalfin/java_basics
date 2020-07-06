import conditions.BonusSetting;
import conditions.PayBet;

public class Operator implements Employee {

    private Company company;
    private Double salary;

    public Operator(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    @Override
    public Double getSalary() {
        return this.salary;
    }


    @Override
    public Double getMonthSalary() {
        return PayBet.OPERATOR.getBet() * getTimeWorkedPerMonth() +
                company.getIncome() * BonusSetting.OPERATOR.getBonusAmount();
    }
}