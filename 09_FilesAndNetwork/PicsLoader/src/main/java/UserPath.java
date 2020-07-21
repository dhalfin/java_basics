import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class UserPath {

    public static Path request(String message) {
        var scanner = new Scanner(System.in);
        Path path;

        while (true) {
            System.out.println(message);
            String string = scanner.nextLine().trim();
            try {
                path = Paths.get(string);
                if (!Files.exists(path)) {
                    try {
                        Files.createDirectories(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            } catch (InvalidPathException e) {
                System.out.println(string + " - неправильный путь");
            }
        }
        return path;
    }
}
