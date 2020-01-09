package com.finartz.ticketHomework.service;

import com.finartz.ticketHomework.dto.AirportDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AirportService {
    Optional<AirportDto> getAirportById(Integer id);

    void createAirport(AirportDto airportDto);
}
