package com.finartz.ticketHomework.service;

import com.finartz.ticketHomework.dto.FlightDto;

import java.util.Optional;


public interface FlightService {
    Optional<FlightDto> getFlightById(Integer id);

    void createFlight(FlightDto flightDto);
}
