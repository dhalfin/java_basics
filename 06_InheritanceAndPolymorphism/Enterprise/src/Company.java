import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Company {

    private double income;
    private List<Employee> employees = new ArrayList<>();

    public Company(double income) {
        this.income = income;
    }

    public Company(double income, List<Employee> employees) {
        this.income = income;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public double getIncome() {
        return income;
    }

    public boolean hire(Employee employee) {
        if (employee != null)
            return this.employees.add(employee);
        return false;
    }

    public boolean hireAll(List<Employee> applicants) {
        return this.employees.addAll(applicants);
    }

    public void fire(int i) {
        employees.remove(i);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++)
            result.add(employees.get(i));
        return result;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++)
            result.add(employees.get(i));
        return result;
    }
}