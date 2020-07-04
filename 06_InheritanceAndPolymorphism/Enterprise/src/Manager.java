import java.math.BigDecimal;

public class Manager implements Employee {

    private Company company;
    private BigDecimal salary = BigDecimal.valueOf(60000);
    public void setCompany(Company company) {
        this.company = company;
    }


    @Override
    public BigDecimal getMonthSalary() {

        if (Company.get) {
            return salary.add(income.multiply(BigDecimal.valueOf(0.05)));
        }
        return salary;

    }
}
