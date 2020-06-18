import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал      5000.37     рублей, Петя -   7563.99   рубля, а Маша   -    30000.01   рублей";

        Pattern pattern = Pattern.compile("(\\d+(\\.\\d*)?)|(\\.\\d+)");
        Matcher matcher = pattern.matcher(text);

        double total = 0.0;

        while(matcher.find()) {
            total += Double.parseDouble(matcher.group());
        }

        System.out.println("Total = " + total);
    }
}
