import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LocalDateLoader {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write your birthday : (" + dtf + ") : ");
        String input = scanner.nextLine().trim();
        LocalDate birthday = LocalDate.parse(input, dtf);
        LocalDate today = LocalDate.now();

        DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("ru"));

        for (int i = 0; !birthday.isAfter(today); i++) {
            System.out.println(i + " - " + printFormat.format(birthday) + " - " + birthday.getDayOfWeek());
           birthday = birthday.plusYears(1);
        }
    }
}
