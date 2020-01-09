package com.finartz.ticketHomework.service.impl;

import com.finartz.ticketHomework.dao.FlightDao;
import com.finartz.ticketHomework.dto.FlightDto;
import com.finartz.ticketHomework.entity.Flight;
import com.finartz.ticketHomework.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDao flightDao;

    @Override
    public Optional<FlightDto> getFlightById(Integer id) {
        Optional<Flight> flightOptional = flightDao.findById(id);
        if (flightOptional.isPresent()) {
            Flight flight = flightOptional.get();
            FlightDto flightDto = new FlightDto();
            flightDto.setAirlineId(flight.getAirlineId());
            flightDto.setRouteId(flight.getRouteId());
            flightDto.setCuota(flight.getCuota());
            flightDto.setPrice(flight.getPrice());
            return Optional.of(flightDto);
        }
        return null;
    }

    @Override
    public void createFlight(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setAirlineId(flightDto.getAirlineId());
        flight.setRouteId(flightDto.getRouteId());
        flight.setCuota(flightDto.getCuota());
        flight.setPrice(flightDto.getPrice());
        flightDao.save(flight);
    }

}
