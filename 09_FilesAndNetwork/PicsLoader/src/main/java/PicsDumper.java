import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class PicsDumper {

    private Path intendPath;
    private String originURL;

    public PicsDumper(Path intendPath, String originURL) {
        this.intendPath = intendPath;
        this.originURL = originURL;
    }

    void run() {
        try {
            System.out.println("Пожалуйста, подождтите мгновение... ");
            Document doc = Jsoup.connect(originURL).get();
            Elements pics = doc.getElementsByTag("img");

            for (Element pic : pics) {
                String ABS_URL = pic.absUrl("src");

                String picName = ABS_URL.substring(ABS_URL.lastIndexOf("/") + 1);
                if (isFileNameValid(picName) && isImageFile(picName)) {
                    InputStream is = new URL(pic.absUrl("src")).openStream();
                    Files.copy(is, Paths.get(intendPath + File.separator + picName), REPLACE_EXISTING);
                }
                System.out.println(picName);
            }
            System.out.println("Операция завершена, проверьте в папке назначения!");
        } catch (IOException e) {
            System.out.println("IOException в блоке try =>" + e.getMessage());
        }
    }

    //    private static boolean isFileNameValid(String name) {
//        Pattern pattern = Pattern.compile("(.+)?[><\\|\\?*/:\\\\\"](.+)?");
//        Matcher matcher = pattern.matcher(name);
//        return !matcher.find();
//    }
    private static boolean isFileNameValid(String name) {
        return name.matches("(.+)?[><\\|\\?*/:\\\\\"](.+)?");
    }

    private static boolean isImageFile(String name) {
        Pattern pattern = Pattern.compile("([^s]+(.(?i)(jpg|png|gif|bmp|tiff))$)");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }
}


