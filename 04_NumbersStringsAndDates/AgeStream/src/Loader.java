import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class Loader {
    public static void main(String[] args) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        inputFormat.setLenient(false);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write your birthday : (" + inputFormat.toPattern() + ") : ");
        String input = scanner.nextLine().trim();

        Date date = parseDate(input, inputFormat);
        if(date == null) {
            System.out.println("Invalid date");
            return;
        }

        Calendar birthday = new GregorianCalendar();
        birthday.setTime(date);

        boolean February29 = is29February(birthday);

        Calendar now = new GregorianCalendar();
        DateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy - EEE", Locale.UK);
        //DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE", new Locale("ru"));

        for(int i = 0; !birthday.after(now); i++) {
            System.out.println(i + " - " + outputFormat.format(birthday.getTime()));
            birthday.add(Calendar.YEAR, 1);
            if(February29 && birthday.get(Calendar.YEAR) % 4 == 0) {
                birthday.add(Calendar.DATE, 1);
            }
        }
    }

    public static Date parseDate(String str, DateFormat format) {
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = format.parse(str, parsePosition);
        if(date == null || parsePosition.getIndex() < str.length()) {
            return null;
        } else {
            return date;
        }
    }

    public static boolean is29February(Calendar calendar) {
        return calendar.get(Calendar.MONTH) == Calendar.FEBRUARY && calendar.get(Calendar.DATE) == 29;
    }
}
