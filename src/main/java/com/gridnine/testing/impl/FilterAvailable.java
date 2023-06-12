package com.gridnine.testing.impl;

import com.gridnine.testing.Filterable;
import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterAvailable implements Filterable {
    LocalDateTime startFlightTime;

    public FilterAvailable(LocalDateTime startFlightTime) {
        this.startFlightTime = startFlightTime;
    }

    @Override
    public List<Flight> getFilteredFlights(List<Flight> flights) {
        Predicate<Flight> isPresent = f -> (f.getSegments().stream()
                .findFirst().filter(s -> s.getDepartureDate().isAfter(startFlightTime)).isPresent());
        System.out.println("Список всех доступных полетов:");
        return flights.stream()
                .filter(isPresent).collect(Collectors.toList());
    }
}
