import java.util.Scanner;
import java.util.regex.Pattern;

public class Loader {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^((8|\\+7)[\\-]?)?(\\(?\\d{3}\\) ?[\\-]?)?[\\d\\-]{7,10}$");
    public static boolean isPhone(String string) { return PHONE_PATTERN.matcher(string).matches(); }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите номер телефона: ");
        String command = scanner.nextLine();
        String temp = command.replaceAll("[()\\-+\\s]", "");
        int span = temp.length();
        if (temp.substring(0, 1).equals("7") || temp.substring(0, 1).equals("8") || span == 10) {
            if (span == 10 || span == 11) {
                if(isPhone(temp)) {
                    temp = temp.substring(span - 10);
                    temp = "7" + temp;
                }
                System.out.println(temp);
            } else if (span > 11) {
                System.out.println("Формат номера неверный!");
            } else if (span <= 7) {
                System.out.println("Формат номера неверный!");
            } else {
                System.out.println("Формат номера неверный!");
            }
            //System.out.println(temp);
        } else {
            System.out.println("Формат номера неверный!");
        }
    }
}

//    public int getCountsOfDigits(int number) {
//        return String.valueOf(Math.abs(number)).length();
//    }

