import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) throws IOException {
        String fio = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String [] names = extractFIO(fio);
        if (names == null) {
            System.out.println("Неверный ввод данных, введите Ваше полное ФИО");
        }
        else {
            System.out.println("Фамилия: " + names[0]);
            System.out.println("Имя: " + names[1]);
            System.out.println("Отчество: " + names[2]);
        }
    }

    private final static Pattern FIO_PATTERN = Pattern.compile("\\s*+([А-ЯЁ][а-яё]++(?:-[А-ЯЁ][а-яё]++)?)\\s++([А-ЯЁ][а-яё]++)\\s++([А-ЯЁ][а-яё]++)");

    public static String[] extractFIO(String fio) {
        Matcher matcher = FIO_PATTERN.matcher(fio);
        if(matcher.matches()) {
            return new String[] { matcher.group(1), matcher.group(2), matcher.group(3)};
        }
        else {
            return null;
        }
    }
}
