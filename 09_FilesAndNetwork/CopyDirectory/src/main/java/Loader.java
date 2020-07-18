import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Пожалуйста, введите путь до папки, из которой будет произведено копирование: ");
            String firstPath = reader.readLine().trim();
            System.out.println("Пожалуйста, введите путь до папки, в которой будет проведена операция копирования: ");
            String secondPath = reader.readLine().trim();
            File origin = new File(firstPath);
            File purpose = new File(secondPath);
            //File source = new File("C:\\Users\\Dinar\\Desktop\\Native-JS");
            //File dest = new File("C:\\Users\\Dinar\\Desktop\\test");
            copyFile(origin, purpose);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void copyFile(File source, File dest) throws IOException {
        FileUtils.copyDirectoryToDirectory(source, dest);
    }
}
