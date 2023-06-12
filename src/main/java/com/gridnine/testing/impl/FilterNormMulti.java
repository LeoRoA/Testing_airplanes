package com.gridnine.testing.impl;

import com.gridnine.testing.Filterable;
import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.util.ArrayList;
import java.util.List;

public class FilterNormMulti implements Filterable {


    public FilterNormMulti() {
    }

    @Override
    public List<Flight> getFilteredFlights(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            boolean checkDepArrTime = true;
            for (Segment segment : segments) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    checkDepArrTime = false;
                    break;
                }
            }
            if (checkDepArrTime) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
