import java.math.BigDecimal;

public class TopManager implements Employee {

    private Company company;
    private BigDecimal salary = BigDecimal.valueOf(95000);
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public BigDecimal getMonthSalary() {
        Company company;
        if (Company.get) {
            return salary.add(salary.multiply(BigDecimal.valueOf(1.5)));
        }
        return salary;
    }
}
