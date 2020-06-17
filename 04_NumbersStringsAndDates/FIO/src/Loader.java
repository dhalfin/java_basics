import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {
    public static void main(String[] args) throws IOException {
        String fio = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String [] names = extractFIO(fio);
        if (names == null) {
            System.out.println("Неверный ввод данных. Введите полностью ФИО!");
        }
        else {
            System.out.println("Фамилия: " + names[0]);
            System.out.println("Name: " + names[1]);
            System.out.println("Отчество: " + names[2]);
        }
    }

    public static String[] extractFIO(String fio) {
        fio = fio.trim();

        int firstSpace = fio.indexOf(" ");
        int lastSpace = fio.lastIndexOf(" ");

        if(firstSpace == lastSpace)
            return null;

        String surname = fio.substring(0, firstSpace);
        String name = fio.substring(firstSpace + 1, lastSpace);
        String patronymic = fio.substring(lastSpace + 1);

        name = name.trim();
        if(name.isEmpty() || name.contains(" "))
            return null;

        return  new String[] {surname, name, patronymic};
    }
}
