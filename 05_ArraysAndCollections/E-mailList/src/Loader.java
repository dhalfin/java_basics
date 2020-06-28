import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> emailList = new TreeSet<>();
        Pattern ORDER_PATTERN = Pattern.compile("(?<commandType>ADD|LIST)\\s*(?<email>^(.+)@(.+)$)");

        for(;;) {
            System.out.println("Пожалуйста, введите E-mail после команды ADD или напечатайте список командой LIST: ");
            String order = reader.readLine().trim();
            //Pattern ORDER_PATTERN = Pattern.compile("(?<commandType>ADD|LIST)\\s*(?<email>^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$)");
            Matcher matcher = ORDER_PATTERN.matcher(order);
            String commandType = matcher.group("commandType");
            String email = matcher.group("email");
            if (commandType.equals("LIST")) {
                for (String name : emailList) {
                    System.out.println(name);
                }
            } else if (commandType.equals("ADD")){
                emailList.add(email);
            } else {
                System.out.println("Неправильно введена команда!");
            }
        }
    }
}
