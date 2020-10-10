import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JSONReader {

    public void getNumberOfStations(String path) throws Exception {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(path));
        JSONObject metroJsonObject = (JSONObject) object;
        JSONObject stationsObj = (JSONObject) metroJsonObject.get("stations");
        stationsObj.keySet().forEach(k -> {
            JSONArray stationsArray = (JSONArray) stationsObj.get(k);
            System.out.println("Станций на линии " + k + " : " + stationsArray.size());
        });
    }

    public void getNumberOfConnections(String path) throws Exception {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(path));
        JSONObject metroJsonObject = (JSONObject) object;
        JSONArray connectionsArray = (JSONArray) metroJsonObject.get("connections");
        System.out.println("Всего переходов в метро Москвы: " + connectionsArray.size());
    }
}
