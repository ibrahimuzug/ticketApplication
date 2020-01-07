package com.finartz.ticketHomework.airport;

import com.finartz.ticketHomework.dao.AirportDao;
import com.finartz.ticketHomework.entity.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportDao airportDao;

    @Override
    public Optional<Airport> getAirportById(Integer id) {
        return airportDao.findById(Long.valueOf(id));
    }

    @Override
    public List<Airport> getAllAirports() {
        return (List<Airport>) airportDao.findAll();
    }
}
