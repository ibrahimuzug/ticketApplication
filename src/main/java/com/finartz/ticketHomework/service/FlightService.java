package com.finartz.ticketHomework.service;

import com.finartz.ticketHomework.dto.FlightDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FlightService {
    Optional<FlightDto> getFlightById(Integer id);

    void createFlight(FlightDto flightDto);
}
