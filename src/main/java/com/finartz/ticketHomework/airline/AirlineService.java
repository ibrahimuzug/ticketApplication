package com.finartz.ticketHomework.airline;

import com.finartz.ticketHomework.entity.Airline;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AirlineService {
    Optional<Airline> getAirlineById(Integer id);
}
