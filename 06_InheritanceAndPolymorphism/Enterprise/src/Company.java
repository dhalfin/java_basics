import java.math.BigDecimal;
import java.util.*;

abstract public class Company {

 private Manager manager;
 private TopManager topManager;
 private Operator operator;
 private ArrayList<Manager> managers = new ArrayList<>();
 private ArrayList<TopManager> topManagers = new ArrayList<>();
 private ArrayList<Operator> operators = new ArrayList<>();
 public BigDecimal income = BigDecimal.valueOf((Math.random() * (140000 - 115000)) + 115000);


 public ArrayList<Employee> getTopSalaryStaff(int count) {
  ArrayList<Employee> list = new List<Employee>((Comparator<Employee>) (o1, o2) -> {
   if (o1.getMonthSalary() > o2.getMonthSalary()) {
    return -1;
   }
   if (o1.getMonthSalary() < o2.getMonthSalary()) {
    return 1;
   }
   return 0;
  });
  for (int i = 0; i < count; i++) {
   list.add(new Manager())
  }
  return list;
   }

 public List<Employee> getLowestSalaryStaff(int count) {
  return null;
 }

 public void hire(Manager manager, TopManager topManager, Operator operator) {
  this.manager = manager;
  this.topManager = topManager;
  this.operator = operator;
 }

 public void hireAll(ArrayList<Manager> managers, ArrayList<TopManager> topManagers, ArrayList<Operator> operators) {
  this.managers = managers;
  this.topManagers = topManagers;
  this.operators = operators;
 }

 public Manager fire() {
  return manager;
 }

 public BigDecimal getIncome() {
  return income;
 }
}



