package com.finartz.ticketHomework.service;

import com.finartz.ticketHomework.dto.AirlineDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface AirlineService {
    Optional<AirlineDto> getAirlineById(Integer id);

    void createAirline(AirlineDto airlineDto);
}
