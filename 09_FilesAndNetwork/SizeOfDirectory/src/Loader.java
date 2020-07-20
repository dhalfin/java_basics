import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Loader {
    public static void main(String[] args) {
        try {
            // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // System.out.println("Пожалуйста, введите путь до папки: ");
            // String command = reader.readLine().trim();
            // Path directory = Paths.get("C:\\Users\\Dinar\\Desktop\\Native-JS");
            Path directory = Paths.get(args[0]);
            long value = Files.walk(directory)
                    .filter(p -> p.toFile().isFile())
                    .mapToLong(p -> p.toFile().length())
                    .sum();
            System.out.println("Размер папки " + args[0] + " cоставляет " + value + " байт");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
