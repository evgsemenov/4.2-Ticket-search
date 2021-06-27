package manager;

import domain.Flight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import repository.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Manager {
    private Repository repo = new Repository();

    public void save(Flight flight) {
        repo.save(flight);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public Flight[] findByDestinations(String from, String to) {
        Flight[] foundedFlights = new Flight[0];
        for (Flight flight : repo.findAll()) {
//            if ((flight.getFrom() == from) && (flight.getTo() == to)) {
                if (((flight.getFrom().equalsIgnoreCase(from))) && (flight.getTo().equalsIgnoreCase(to))); {
                add(flight);
            }
        }
        return foundedFlights;
    }

    public void add(Flight flight) {
        Flight[] foundedFlights = new Flight[0];
        int length = foundedFlights.length + 1;
        Flight[] tmp = new Flight[length];
        System.arraycopy(foundedFlights, 0, tmp, 0, foundedFlights.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = flight;
        foundedFlights = tmp;
    }
}

