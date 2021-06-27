package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Flight implements Comparable<Flight> {
    private int id;
    private int cost;
    private String from;
    private String to;
    private int flightTime;

    @Override
    public int compareTo(Flight o) {
        return this.cost - o.cost;
    }
}

