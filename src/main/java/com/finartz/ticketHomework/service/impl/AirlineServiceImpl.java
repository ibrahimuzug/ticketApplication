package com.finartz.ticketHomework.service.impl;

import com.finartz.ticketHomework.dao.AirlineDao;
import com.finartz.ticketHomework.dto.AirlineDto;
import com.finartz.ticketHomework.entity.Airline;
import com.finartz.ticketHomework.service.AirlineService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {

    private final AirlineDao airlineDao;

    public AirlineServiceImpl(AirlineDao airlineDao) {
        this.airlineDao = airlineDao;
    }

    @Override
    public Optional<AirlineDto> getAirlineById(Integer id) {
        Optional<Airline> airlineOptional = airlineDao.findById(id);
        if (airlineOptional.isPresent()) {
            Airline airline = airlineOptional.get();
            AirlineDto airlineDto = new AirlineDto();
            airlineDto.setCode(airline.getCode());
            airlineDto.setName(airline.getName());
            return Optional.of(airlineDto);
        }
        return null;
    }

    @Override
    public void createAirline(AirlineDto airlineDto) {
        Airline airline = new Airline();
        airline.setName(airlineDto.getName());
        airline.setCode(airlineDto.getCode());
        airlineDao.save(airline);
    }

}
