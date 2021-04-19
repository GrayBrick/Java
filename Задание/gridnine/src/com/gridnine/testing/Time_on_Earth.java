package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Time_on_Earth implements Rule
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
            for (int i = 0; i < flight.getSegments().size() - 1; i++)
            {
                if (flight.getSegments().get(i + 1).getDepartureDate().minusHours(2).isAfter(flight.getSegments().get(i).getArrivalDate()))
                    rule_not_followed = true;
            }
            if (!rule_not_followed)
                filtered_flight_list.add(flight);
        }
        return filtered_flight_list;
    }
}
