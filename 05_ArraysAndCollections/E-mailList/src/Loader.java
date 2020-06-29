import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    private static TreeSet<String> emailList = new TreeSet<>();
    private final static Pattern ORDER_PATTERN = Pattern.compile("(?<commandType>ADD|LIST)\\s*(?<email>(.+)@(.+))?");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (;;) {
            System.out.println("Пожалуйста, введите E-mail после команды ADD или напечатайте список командой LIST: ");
            String order = reader.readLine().trim();
            Matcher matcher = ORDER_PATTERN.matcher(order);
            if (matcher.find()) {
                String commandType = matcher.group("commandType");
                String email = matcher.group("email");
                if (commandType.equals("LIST")) {
                    for (String name : emailList) {
                        System.out.println(name);
                    }
                } else if (commandType.equals("ADD")) {
                    if (emailList.contains(email)) {
                        System.out.println("Этот E-Mail уже существует в списке!");
                    }
                }
                emailList.add(email);
            } else {
                    System.out.println("Неправильно введена команда!");
                }
            }
        }
    }

