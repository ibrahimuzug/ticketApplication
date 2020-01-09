package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.AirportDto;
import com.finartz.ticketHomework.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<AirportDto> getAirportById(@PathVariable("id") Integer id) {
        return airportService.getAirportById(id);
    }

    @PostMapping("/create")
    public void createAirport(@RequestBody AirportDto airportDto) {
        airportService.createAirport(airportDto);
    }

}
