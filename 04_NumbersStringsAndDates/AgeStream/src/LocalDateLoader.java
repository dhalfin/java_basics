
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public class LocalDateLoader {
    public static void main(String[] args) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        inputFormat.setLenient(false);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write your birthday : (" + inputFormat.toPattern() + ") : ");
        String input = scanner.nextLine().trim();

        String yearInput = scanner.nextLine().trim();
        String monthInput = scanner.nextLine().trim();
        String dayInput = scanner.nextLine().trim();

        int y = Integer.parseInt( yearInput );
        int m = Integer.parseInt( monthInput );  // 1-12 for January-December.
        int d = Integer.parseInt( dayInput );


        Date date = Loader.parseDate(input, inputFormat);
        if(date == null) {
            System.out.println("Invalid date");
            return;
        }
        LocalDate birthday = LocalDate.of(y, m, d);
        LocalDate today = LocalDate.now();
//        int Y = birthday.getYear();
//        int M = birthday.getMonthValue();
//        int dayOfMonth = birthday.getDayOfMonth();
        DayOfWeek dayOfWeek = birthday.getDayOfWeek();

//        Calendar birthday = new GregorianCalendar();
//        birthday.setTime(date);

        boolean February29 = is29February(birthday);

        //Calendar now = new GregorianCalendar();
        //DateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy - EEE", Locale.UK);
        DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("ru"));
        //String formattedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(date);
        for(int i = 0; !birthday.isAfter(today); i++) {
            System.out.println(i + " - " + printFormat.format(birthday) + " - " + dayOfWeek);
            birthday.plusYears(1);
            if(February29 && birthday.getYear() % 4 == 0) {
                birthday.plusYears(1);
            }
        }

        public static boolean is29February(Calendar calendar) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern( "ddMMM" , Locale.ENGLISH );

            String input2 = "29FEB";
            MonthDay md = MonthDay.parse( input2 , f );
            int yearNumber today.getYear();
            LocalDate ld = null;
            if( md.equals( MonthDay.of( 2 , 29 )  && ( ! Year.of( today ).isLeap() ) ) {

                ld = md.atYear( yearNumber + x );
            } else {
                ld = md.atYear( yearNumber );
            }
            return calendar.get(Calendar.MONTH) == Calendar.FEBRUARY && calendar.get(Calendar.DATE) == 29;
        }
    }
    }
}
