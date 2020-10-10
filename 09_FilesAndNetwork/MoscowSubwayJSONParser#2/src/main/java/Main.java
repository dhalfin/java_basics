import subwayMap.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {

        Parser parser = new Parser("https://www.moscowmap.ru/metro.html#lines");
        JSONArray linesArray = parser.parseLine();
        JSONObject stationsObject = parser.parseStation();
        parser.parseConnection();
        TreeSet<StationsConnection> connections = parser.getContainerStations().getConnections();
        JSONArray connectionsArray = parser.writeConnectionsInJSON(connections);
        Subway subway = new Subway(stationsObject, linesArray, connectionsArray);

        JSONWriter jsonWriter = new JSONWriter();
        jsonWriter.writeInJSONFile(subway.getSubwayObject(), "src/main/resources/metro.json");

        JSONReader jsonReader = new JSONReader();
        jsonReader.getNumberOfStations("src/main/resources/metro.json");
        jsonReader.getNumberOfConnections("src/main/resources/metro.json");
    }
}
