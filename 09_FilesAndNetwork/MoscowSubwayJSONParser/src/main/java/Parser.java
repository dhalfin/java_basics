import SubwayEntities.Line;
import SubwayEntities.Stop;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Data
public class Parser {

    private List<Line> lines = new LinkedList<>();
    private Map<String, List<String>> stops = new TreeMap<>();
    private List<List<Stop>> transitions = new ArrayList<>();

    private void parseTransitions(Elements cols, String stopName) {
        List<String> transitionsLine = cols.get(3).children().eachAttr("title");
        List<String> transitionsNumber = cols.get(3).children().eachText();
        List<String> lineNumbers = cols.get(0).children().eachText();
        String lineId = lineNumbers.get(1);
        if (transitionsNumber.size() != 0) {
            List<Stop> temp = new ArrayList<>();
            temp.add(new Stop(lineId, stopName));
            for (int i = 0; i < transitionsNumber.size(); i++) {
                temp.add(new Stop(transitionsNumber.get(i), transitionsLine.get(i)));
            }
            transitions.add(temp);
        }
    }

    private void parseLines(String lineName, List<String> lineNumbers) {
        Line line = new Line(lineNumbers.get(0), lineName);
        if (!lines.contains(line)) lines.add(line);
    }

    private void parseStop(String stopName, List<String> lineNumbers, List<String> transitionsLineName) {
        String lineId = lineNumbers.get(0);
        if (!stops.containsKey(lineId)) {
            stops.put(lineId, new ArrayList<>());
        }
        stops.get(lineId).add(stopName);

        if (transitionsLineName.size() == 2) {
            if (!stops.containsKey(lineNumbers.get(1)))
                stops.put(lineNumbers.get(1), new ArrayList<>());
            else {
                stops.get(lineNumbers.get(1)).add(stopName);
            }
        }
    }

    protected String parseFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> sb.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    protected void parseInputDataHtmlFile(String file) {
        Document document = Jsoup.parse(parseFile(file));
        Element table = document.select("table").get(3);
        Elements rows = table.select("tr");
        rows.stream().skip(1).forEach((row) -> {
            Elements cols = row.select("td");
            String stopName = cols.get(1).text();
            String lineName = cols.get(0).child(1).attr("title");
            List<String> lineNumbers = cols.get(0).children().eachText();
            List<String> transitionsLineName = cols.get(0).children().eachAttr("title");
            List<String> transitionsNumber = cols.get(3).children().eachText();

            parseStop(stopName, lineNumbers, transitionsLineName);
            parseLines(lineName, lineNumbers);
            if (transitionsNumber.size() != 0) {
                parseTransitions(cols, stopName);
            }
        });
    }

    public List<Line> getLines() {
        return lines;
    }

    public Map<String, List<String>> getStops() {
        return stops;
    }

    public List<List<Stop>> getTransitions() {
        return transitions;
    }
}

