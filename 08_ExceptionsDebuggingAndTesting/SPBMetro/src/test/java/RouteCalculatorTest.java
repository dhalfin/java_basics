import core.Line;
import core.Station;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RouteCalculatorTest {

    public RouteCalculator routeCalculator;
    public StationIndex stationIndex;

    public List<Station> stations;
    public List<Station> noConnection;
    public List<Station> oneConnection;
    public List<Station> twoConnection;
    public List<Station> actualResultStationList;

    public Line line1;
    public Station firstStop;
    public Station secondStop;
    public Station thirdStop;

    public Line line2;
    public Station fourthStop;
    public Station fifthStop;
    public Station sixthStop;

    public Line line3;
    public Station seventhStop;
    public Station eighthStop;
    public Station ninthStop;

    @BeforeClass
    public void setUp() {

        line1 = new Line(1, "line1");
        firstStop = new Station("station1", line1);
        secondStop = new Station("station2", line1);
        thirdStop = new Station("station3", line1);

        line2 = new Line(2, "line2");
        fourthStop = new Station("station4", line2);
        fifthStop = new Station("station5", line2);
        sixthStop = new Station("station6", line2);

        line3 = new Line(3, "line3");
        seventhStop = new Station("station7", line3);
        eighthStop = new Station("station8", line3);
        ninthStop = new Station("station9", line3);

        routeCalculator = new RouteCalculator(initStationIndex());
    }

    @Test
    public void calculateDuration() {
        stations = Stream.of(firstStop, secondStop, thirdStop, fourthStop, fifthStop, sixthStop, seventhStop, eighthStop, ninthStop)
                .collect(Collectors.toList());
        double expected = RouteCalculator.calculateDuration(stations);
        double actual = 22;
        assertEquals(expected, actual,0.0);
    }

    @Test
    public void getShortRoutes() {
        noConnection = Stream.of(firstStop, secondStop, thirdStop)
                .collect(Collectors.toList());
        actualResultStationList = routeCalculator.getShortestRoute(firstStop, thirdStop);
        assertEquals(noConnection, actualResultStationList);
    }

    @Test
    public void getShortRoutesOneConnection() {
        oneConnection = Stream.of(firstStop, secondStop, thirdStop, sixthStop, fifthStop)
                .collect(Collectors.toList());
        actualResultStationList = routeCalculator.getShortestRoute(firstStop, fifthStop);
        assertEquals(oneConnection, actualResultStationList);
    }

    @Test
    public void getShortRoutesTwoConnection() {
        twoConnection = Stream.of(firstStop, secondStop, thirdStop, sixthStop, fifthStop, fourthStop, seventhStop, eighthStop)
                .collect(Collectors.toList());
        actualResultStationList = routeCalculator.getShortestRoute(firstStop, eighthStop);
        assertEquals(twoConnection, actualResultStationList);
    }

    public StationIndex initStationIndex() {
        stationIndex = new StationIndex();
        Stream.of(firstStop, secondStop, thirdStop, fourthStop, fifthStop, sixthStop, seventhStop, eighthStop, ninthStop)
                .peek(e -> e.getLine().addStation(e)).forEach(stationIndex::addStation);
        List<Station> connect1 = Arrays.asList(thirdStop, sixthStop);
        List<Station> connect2 = Arrays.asList(fourthStop, seventhStop);
        stationIndex.addConnection(connect1);
        stationIndex.addConnection(connect2);
        Stream.of(line1, line2, line3).forEach(stationIndex::addLine);
        return stationIndex;
    }
}
