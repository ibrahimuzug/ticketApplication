package com.finartz.ticketHomework.airport;

import com.finartz.ticketHomework.entity.Airport;
import java.util.List;
import java.util.Optional;

public interface AirportService {

    Optional<Airport> getAirportById(Integer id);

    List<Airport> getAllAirports();
}
