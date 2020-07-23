import SubwayEntities.Line;
import SubwayEntities.Subway;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Loader {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static String fileName = Paths.get("src", "main", "resources", "moscow_subway.json").toString();
    private static JSONParser jsonParser = new JSONParser();
    private static Subway subway;
    private static Parser parser = new Parser();

    public static void main(String[] args) throws IOException, ParseException {
        String file = Paths.get("src", "main", "resources", "stations.html").toString();
        parser.parseInputDataHtmlFile(file);
        createJsonFile();
        readJsonAndPrintStations();
    }

    static void createJsonFile() throws IOException {
        subway = new Subway(parser.getLines(), parser.getStops(), parser.getTransitions());
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(GSON.toJson(subway));
        }
    }

    static void readJsonAndPrintStations() throws ParseException {
        JSONObject jsonObject = (JSONObject) jsonParser.parse(parser.parseFile(fileName));
        Map<String, List<String>> stops = (Map<String, List<String>>) jsonObject.get("stops");
        verifyStops(stops);
    }

    private static void verifyStops(Map<String, List<String>> stops) {
        for (String lineId : stops.keySet()) {
            JSONArray stopsArray = (JSONArray) stops.get(lineId);
            for (Line line : subway.getLines()) {
                printLineDescription(lineId, stopsArray, line);
            }
        }
    }

    private static void printLineDescription(String lineId, JSONArray stopsArray, Line line) {
        if (line.getId().equals(lineId)) {
            System.out.println("Линия " + lineId + " " + line.getName()
                    + " -> количество станций: " + stopsArray.size());
        }
    }
}
