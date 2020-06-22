import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {

    public static void main(String[] args) throws IOException {
        String enteredText = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String safe = searchAndReplaceDiamonds(enteredText);
        if (safe.length() == 0) {
            System.out.println("Неверный ввод данных. Пожалуйста, введите Ваши данные!");
        }
        else {
            System.out.println(safe);
        }
    }

    public static String searchAndReplaceDiamonds(String text) {
        text = text.trim();
        String placeholder = "***";
        //String text = "«Номер кредитной карты <4008 1234 5678> 8912»";
        //String a = text.replaceAll("<.+>", placeholder);
        String a = text.replaceAll("<.+?>", placeholder);
        return a;
    }
}



