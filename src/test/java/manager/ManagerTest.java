package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import domain.Flight;
import repository.Repository;

import java.util.Arrays;

public class ManagerTest {
    private Manager manager = new Manager();
    private Repository repository = new Repository();
    private Flight flight1 = new Flight(1, 5100_00, "DME", "LED", 100);
    private Flight flight2 = new Flight(2, 5000_00, "LED", "DME", 95);
    private Flight flight3 = new Flight(3, 7000_00, "PRG", "MUN", 110);
    private Flight flight4 = new Flight(4, 18000_00, "MUN", "DME", 180);
    private Flight flight5 = new Flight(5, 8900_00, "DME", "LED", 90);
    private Flight flight6 = new Flight(6, 12000_00, "PRG", "MUN", 110);
    private Flight flight7 = new Flight(7, 8000_00, "PRG", "MUN", 105);
    private Flight flight8 = new Flight(8, 17000_00, "LED", "PRG", 150);
    private Flight flight9 = new Flight(9, 8500_00, "MUN", "PRG", 105);

    @BeforeEach
    public void setupFlights() {
        repository.save(flight1);
        repository.save(flight2);
        repository.save(flight3);
        repository.save(flight4);
        repository.save(flight5);
        repository.save(flight6);
        repository.save(flight7);
        repository.save(flight8);
        repository.save(flight9);
    }

    @Test
    public void shouldSortByCost(){
    Flight[] expected = new Flight[]{flight2, flight1, flight3, flight7, flight9, flight5, flight6, flight8, flight4};
    Flight[] actual = new Flight[]{flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8, flight9};

    Arrays.sort(actual);

    assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindByDestinationsAndSortByCost(){
        Flight[] expected = new Flight[]{flight1, flight5};
        Flight[] actual = manager.findByDestinations("DME", "LED");

        Arrays.sort(actual);

        assertArrayEquals(actual, expected);
    }

    @Test
    public void  shouldFindAll(){
        Flight[] expected = new Flight[]{flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8, flight9};
        Flight[] actual = repository.findAll();

        assertArrayEquals(actual, expected);
    }
}