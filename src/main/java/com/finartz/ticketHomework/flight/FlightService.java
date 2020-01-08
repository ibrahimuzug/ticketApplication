package com.finartz.ticketHomework.flight;

import com.finartz.ticketHomework.entity.Flight;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FlightService {
    Optional<Flight> getFlightById(Integer id);
}
