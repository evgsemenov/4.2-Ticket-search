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
            if (((flight.getFrom().equalsIgnoreCase(from))) && (flight.getTo().equalsIgnoreCase(to))) {
                Flight[] tmp = new Flight[foundedFlights.length + 1];
                System.arraycopy(foundedFlights, 0, tmp, 0, foundedFlights.length);
                tmp[tmp.length - 1] = flight;
                foundedFlights = tmp;
            }
        }
        return foundedFlights;
    }
}
