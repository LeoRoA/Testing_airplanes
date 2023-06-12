package com.gridnine.testing.impl;

import com.gridnine.testing.Filterable;
import com.gridnine.testing.Flight;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterSingle implements Filterable {

    public FilterSingle() {
    }

    @Override
    public List<Flight> getFilteredFlights(List<Flight> flights) {
        Predicate<Flight> isSingleAndPresent = f -> (f.getSegments().size() == 1);
        System.out.println("Список доступных полетов с одним рейсом");
        return flights.stream()
                .filter(isSingleAndPresent).collect(Collectors.toList());
    }
}

