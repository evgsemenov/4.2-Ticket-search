package comparator;

import domain.Flight;

import java.util.Comparator;

public class FlightByFlightTimeComparator implements Comparator<Flight> {
    public int compare(Flight o1, Flight o2) {
        return o1.getFlightTime() - o2.getFlightTime();
    }
}

