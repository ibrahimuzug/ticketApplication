package com.finartz.ticketHomework.airport;

import com.finartz.ticketHomework.entity.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Airport> getAirportById(@PathVariable("id") Integer id) {
        return airportService.getAirportById(id);
    }

}
