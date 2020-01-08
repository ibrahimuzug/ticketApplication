package com.finartz.ticketHomework.flight;

import com.finartz.ticketHomework.dao.FlightDao;
import com.finartz.ticketHomework.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDao flightDao;

    @Override
    public Optional<Flight> getFlightById(Integer id) {
        return flightDao.findById(id);
    }

}
