package repository;

import domain.Flight;
import exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
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
    public void shouldFindAll() {
        Flight[] expected = new Flight[]{flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8, flight9};
        Flight[] actual = repository.findAll();

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldThrowNotFoundExceptionIfRemoveByIdNotExist() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(15);
        });
    }
    @Test
    public void shouldRemoveByIdIfExist(){
        repository.removeById(5);
        Flight[] expected = new Flight[]{flight1, flight2, flight3, flight4, flight6, flight7, flight8, flight9 };
        Flight[] actual = repository.findAll();

        assertArrayEquals(actual, expected);
    }
    @Test

    public void shouldFindById(){
        Flight expected = flight4;
        Flight actual = repository.findById(4);
        assertEquals(actual, expected);
    }
}

