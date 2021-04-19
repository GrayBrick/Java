package com.gridnine.testing;

import java.util.List;

public class Main
{
    public static void main(String args[])
    {
        List<Flight> list = FlightBuilder.createFlights();

        if ((list = new Departure_to_the_current_time_point().filter_set(list)) == null)
            System.out.println("Ошибка фильтрации");
        else
            System.out.println("Набор без вылетов до текущего момента времени\n" + list + "\n");

        list = FlightBuilder.createFlights();

        if ((list = new Departure_before_arrival().filter_set(list)) == null)
            System.out.println("Ошибка фильтрации");
        else
            System.out.println("Набор без сегментов с датой прилета раньше времени вылета\n" + list + "\n");

        list = FlightBuilder.createFlights();

        if ((list = new Time_on_Earth().filter_set(list)) == null)
            System.out.println("Ошибка фильтрации");
        else
            System.out.println("Набор с остановками менее 2 часов\n" + list + "\n");
    }
}