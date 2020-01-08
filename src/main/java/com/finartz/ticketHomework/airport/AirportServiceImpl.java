package com.finartz.ticketHomework.airport;

import com.finartz.ticketHomework.dao.AirportDao;
import com.finartz.ticketHomework.entity.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportDao airportDao;

    @Override
    public Optional<Airport> getAirportById(Integer id) {
        return airportDao.findById(id);
    }

}
