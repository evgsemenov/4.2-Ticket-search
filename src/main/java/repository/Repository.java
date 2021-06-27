package repository;

import domain.Flight;
import exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Repository {
    private Flight[] flights = new Flight[0];

    public void save(Flight flight) {
        int length = flights.length + 1;
        Flight[] tmp = new Flight[length];
        System.arraycopy(flights, 0, tmp, 0, flights.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = flight;
        flights = tmp;
    }

    public Flight[] findAll() {
        return flights;
    }

    public Flight findById(int id) {
        for (Flight item : flights) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Flight ID " + id + " not found!");
        }
        int length = flights.length - 1;
        Flight[] tmp = new Flight[length];
        int index = 0;
        for (Flight item : flights) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        flights = tmp;
    }
}
