
public class Operator implements Employee{

    private Company company;
    private int salary = 42000;

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }
}
