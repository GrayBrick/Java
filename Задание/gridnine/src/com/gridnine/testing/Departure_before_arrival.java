package com.gridnine.testing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Departure_before_arrival implements Rule
{
    @Override
    public List<Flight> filter_set(List<Flight> flight_list)
    {
        if (flight_list == null)
            return null;

        List<Flight> filtered_flight_list = new ArrayList<>();
        for (Flight flight : flight_list)
        {
            boolean rule_not_followed = false;
            for (Segment segment : flight.getSegments())
            {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                    rule_not_followed = true;
                if (rule_not_followed)
                    break ;
            }
            if (!rule_not_followed)
                filtered_flight_list.add(flight);
        }
        return filtered_flight_list;
    }
}
