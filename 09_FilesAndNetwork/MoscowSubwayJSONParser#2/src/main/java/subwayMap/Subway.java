package subwayMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Subway {

    private JSONObject subwayObject;

    public Subway(JSONObject stationsObject, JSONArray linesArray, JSONArray connectionsArray) {
        subwayObject = new JSONObject();
        subwayObject.put("stations", stationsObject);
        subwayObject.put("lines", linesArray);
        subwayObject.put("connections", connectionsArray);
    }

    public JSONObject getSubwayObject() {
        return subwayObject;
    }
}
