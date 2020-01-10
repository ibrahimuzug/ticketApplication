package com.finartz.ticketHomework.service.impl;

import com.finartz.ticketHomework.dao.AirportDao;
import com.finartz.ticketHomework.dto.AirportDto;
import com.finartz.ticketHomework.entity.Airport;
import com.finartz.ticketHomework.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportDao airportDao;

    public AirportServiceImpl(AirportDao airportDao) {
        this.airportDao = airportDao;
    }

    @Override
    public Optional<AirportDto> getAirportById(Integer id) {
        Optional<Airport> airportOptional = airportDao.findById(id);
        if (airportOptional.isPresent()) {
            Airport airport = airportOptional.get();
            AirportDto airportDto = new AirportDto();
            airportDto.setCode(airport.getCode());
            airportDto.setName(airport.getName());
            return Optional.of(airportDto);
        }
        return null;
    }


    @Override
    public void createAirport(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setName(airportDto.getName());
        airport.setCode(airportDto.getCode());
        airport.setCountry(airportDto.getCountry());
        airportDao.save(airport);
    }

}
