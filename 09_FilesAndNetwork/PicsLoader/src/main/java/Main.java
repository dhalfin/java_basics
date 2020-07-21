import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = UserPath.request("Введите путь директории для сохранения изображений");
        String url = "https://lenta.ru";

        PicsDumper dumper = new PicsDumper(path, url);
        dumper.run();
    }
}
