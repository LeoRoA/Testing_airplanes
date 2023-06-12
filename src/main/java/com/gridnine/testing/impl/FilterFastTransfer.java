package com.gridnine.testing.impl;

import com.gridnine.testing.Filterable;
import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FilterFastTransfer implements Filterable {
    public FilterFastTransfer() {
    }

    @Override
    public List<Flight> getFilteredFlights(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();

        for (Flight flight : flights) {
            long transferTime = 0;
            Duration duration;
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size(); i++) {
                if ((i != 0)) {

                    duration = Duration.between(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate());
                    transferTime += duration.toSeconds();
                }
            }
            if (transferTime < 7200) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}

