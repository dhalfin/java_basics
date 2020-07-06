
public class TopManager implements Employee {

    private Company company;
    private int salary = 95000;
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company != null) {
            if(company.getIncome() > 10000000) {
                return salary = (int) (salary + salary * 1.5);
            }
        }
        return salary;
    }
}
