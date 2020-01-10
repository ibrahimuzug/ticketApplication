package com.finartz.ticketHomework.service;

import com.finartz.ticketHomework.dto.AirportDto;

import java.util.Optional;

public interface AirportService {
    Optional<AirportDto> getAirportById(Integer id);

    void createAirport(AirportDto airportDto);
}
