package com.gridnine.testing;

import com.gridnine.testing.impl.FilterFastTransfer;
import com.gridnine.testing.impl.FilterNormMulti;
import com.gridnine.testing.impl.FilterSingle;
import com.gridnine.testing.impl.FilterAvailable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.FiltersType.*;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        Filterable filterSingle = createFilter(NORM_SINGLE);
        Filterable filterAllAvailable = createFilter(AVAILABLE_FLIGHTS, LocalDateTime.now());
        Filterable filterCorrectTransfer = createFilter(NORM_MULTI);
        Filterable filterFastTransfer = createFilter(FAST_TRANSFER);

        List<Flight> filteredFlights1 = new ArrayList<>(filterAllAvailable.getFilteredFlights(flights));
        List<Flight> filteredFlights2 = new ArrayList<>(filterCorrectTransfer.getFilteredFlights(flights));
        List<Flight> filteredFlights3 = new ArrayList<>(filterFastTransfer.getFilteredFlights(flights));

        System.out.println("1. Cписок вылетов после текущей даты:");
        filteredFlights1.forEach(System.out::println);
        System.out.println("2. Cписок вылетов с корректными датами вылета/прибытия:");
        filteredFlights2.forEach(System.out::println);
        System.out.println("2. Cписок вылетов с трансфером не превышающим 2 часа:");
        filteredFlights3.forEach(System.out::println);
    }

    static Filterable createFilter(FiltersType filtersType, LocalDateTime... startFlightTime) {
        switch (filtersType) {
            case AVAILABLE_FLIGHTS: {
                return new FilterAvailable(startFlightTime[0]);
            }
            case NORM_SINGLE: {
                return new FilterSingle();
            }
            case NORM_MULTI: {
                return new FilterNormMulti();
            }
            case FAST_TRANSFER: {
                return new FilterFastTransfer();
            }

            default:
                throw new IllegalArgumentException("Фильтр в разработке");
        }
    }


}
