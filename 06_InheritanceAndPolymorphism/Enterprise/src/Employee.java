
public interface Employee {

    default double getTimeWorkedPerMonth() {
        return 165 * Math.random();
    }

    Double getMonthSalary();

    Double getSalary();
}