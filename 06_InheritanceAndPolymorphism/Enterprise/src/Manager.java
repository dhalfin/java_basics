
public class Manager implements Employee {

    private Company company;
    private int salary = 60000;
    public void setCompany(Company company) {
        this.company = company;
    }


    @Override
    public int getMonthSalary() {
        if (company != null) {
            return salary = (int) (salary + company.getIncome() * 0.05);
        }
        return salary;
    }
}
