package com.gridnine.testing;

import java.util.List;

public interface Rule
{
    List<Flight> filter_set(List<Flight> flight_list);
}
