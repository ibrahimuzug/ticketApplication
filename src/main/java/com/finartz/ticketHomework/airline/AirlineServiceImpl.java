package com.finartz.ticketHomework.airline;

import com.finartz.ticketHomework.dao.AirlineDao;
import com.finartz.ticketHomework.entity.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlineDao airlineDao;

    @Override
    public Optional<Airline> getAirlineById(Integer id) {
        return airlineDao.findById(id);
    }

}
