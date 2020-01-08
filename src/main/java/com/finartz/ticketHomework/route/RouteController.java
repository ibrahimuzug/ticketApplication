package com.finartz.ticketHomework.route;

import com.finartz.ticketHomework.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Route> getRouteById(@PathVariable("id") Integer id) {
        return routeService.getRouteById(id);
    }
}
