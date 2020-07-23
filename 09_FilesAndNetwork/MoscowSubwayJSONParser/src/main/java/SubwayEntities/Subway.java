package SubwayEntities;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Subway {
    @SerializedName("lines")
    private List<Line> lines;
    @SerializedName("stops")
    private Map<String, List<String>> stops;
    @SerializedName("transitions")
    private List<List<Stop>> transitions;

    public Subway(List<Line> lines, Map<String, List<String>> stops, List<List<Stop>> transitions) {
        this.lines = lines;
        this.stops = stops;
        this.transitions = transitions;
    }

    public List<Line> getLines() {
        return lines;
    }
}

