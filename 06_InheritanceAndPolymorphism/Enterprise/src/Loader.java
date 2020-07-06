
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Пожалуйста, введите размер дохода компании:  ");

        for (; ; ) {
            try {
                Double command = Double.valueOf(reader.readLine().trim());
                Company skyWayGroup = new Company(command);

                List<Employee> roster = new ArrayList<>();
                for (int i = 0; i < 180; i++)
                    roster.add(new Operator(skyWayGroup));
                for (int i = 0; i < 80; i++)
                    roster.add(new Manager(skyWayGroup));
                for (int i = 0; i < 10; i++)
                    roster.add(new TopManager(skyWayGroup));

                skyWayGroup.hireAll(roster);

                System.out.println("15 самых высоких зарплат в компании: ");
                skyWayGroup.getTopSalaryStaff(15).forEach(i -> System.out.println(String.format("%,.2f руб.", i.getSalary())));
                System.out.println("30 самых низких зарплат в компании: ");
                skyWayGroup.getLowestSalaryStaff(30).forEach(i -> System.out.println(String.format("%,.2f руб.", i.getSalary())));
                System.out.println("Здесь мы увольняем 50% сотрудников! После чего получаем иные результаты:");

                for (int i = 0; i < roster.size() / 2; i++)
                    skyWayGroup.fire(i);
                System.out.println("15 самых высоких зарплат в компании: ");
                skyWayGroup.getTopSalaryStaff(15).forEach(i -> System.out.println(String.format("%,.2f руб.", i.getSalary())));
                System.out.println("30 самых низких зарплат в компании: ");
                skyWayGroup.getLowestSalaryStaff(30).forEach(i -> System.out.println(String.format("%,.2f руб.", i.getSalary())));
            } catch (NumberFormatException e) {
                System.out.println("Введите размер дохода компании в числах! ");
            }
        }
    }
}