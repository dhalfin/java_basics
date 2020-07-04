import java.math.BigDecimal;

public class Operator implements Employee{

    private Company company;
    private BigDecimal salary = BigDecimal.valueOf(42000);

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public BigDecimal getMonthSalary() {
        return salary;
    }
}
