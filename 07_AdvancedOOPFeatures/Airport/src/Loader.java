import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.time.LocalTime;
import java.time.ZoneId;

public class Loader {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        LocalTime presentTime = LocalTime.now();
        LocalTime timePlus2Hours = presentTime.plusHours(2);

        airport.getTerminals().stream()
                .flatMap(flight -> flight.getFlights().stream())
                .filter(f -> f.getType() == Flight.Type.DEPARTURE)
                .filter(f -> {
                    LocalTime tripTime = f.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                    return tripTime.isAfter(presentTime) && tripTime.isBefore(timePlus2Hours);
                })
                .forEach(trip -> {
                    LocalTime timeOfLeaving = trip.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                    System.out.printf("Время вылета %02d:%02d, модель самолета - %s\n",
                            timeOfLeaving.getHour(),
                            timeOfLeaving.getMinute(),
                            trip.getAircraft());
                });
    }
}
