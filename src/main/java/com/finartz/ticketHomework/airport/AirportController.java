package com.finartz.ticketHomework.airport;

import com.finartz.ticketHomework.entity.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
@RequestMapping("airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping
    public @ResponseBody
    List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{code}")
    public @ResponseBody Airport getAirportById(@PathVariable("code") Integer code) {
        return airportService.getAirportById(code);
    }
}
