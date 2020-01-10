package com.finartz.ticketHomework.service;

import com.finartz.ticketHomework.dto.AirlineDto;

import java.util.Optional;

public interface AirlineService {
    Optional<AirlineDto> getAirlineById(Integer id);

    void createAirline(AirlineDto airlineDto);
}
