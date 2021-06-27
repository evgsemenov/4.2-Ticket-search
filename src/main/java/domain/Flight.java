package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Flight implements Comparable<Flight> {
    int id;
    int cost;
    String departure;
    String arrival;
    int flightTime;

    @Override
    public int compareTo(@org.jetbrains.annotations.NotNull Flight o) {
        return this.cost - o.cost;
    }
}

