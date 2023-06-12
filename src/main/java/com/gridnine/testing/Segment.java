package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Segment {
    private final LocalDateTime departureDate;

    private final LocalDateTime arrivalDate;


    Segment(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }


    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '['
                + "время отправления:" + departureDate.format(fmt) +
                ", время прибытия:" + arrivalDate.format(fmt)
                + "]\n";
    }
}
