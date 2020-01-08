package com.finartz.ticketHomework.airport;

import com.finartz.ticketHomework.entity.Airport;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AirportService {
    Optional<Airport> getAirportById(Integer id);
}
