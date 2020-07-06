import java.util.*;

 public class Company {

 private List<Employee> employees_ = new ArrayList<>();
// private int income;
 public List<Employee> getTopSalaryStaff(int count) {


  List<Employee> list = new ArrayList<>((Collection<? extends Employee>) (o1, o2) -> {
  if (o1.getMonthSalary() > o2.getMonthSalary()) {
    return -1;
   }
   if (o1.getMonthSalary() < o2.getMonthSalary()) {
    return 1;
   }
   return 0;
  });

  list = employees_;
  for (int i = 0; i < count; i++) {
   return employees_.;
  }

   }

 public List<Employee> getLowestSalaryStaff(int count) {
  return null;
 }

  public void hire(Employee employee) {
   employees_.add(employee);
  }

  public void hireAll(List<Employee> employees) {
    List<Employee> newList = new ArrayList<Employee>(employees_);
    newList.addAll(employees);
    employees_ = newList;
  }

 public void fire(int i) {
   employees_.remove(i);
 }

 public int getIncome() {
  return (int) (Math.random() * (140000 - 115000) + 115000);
 }
 }




