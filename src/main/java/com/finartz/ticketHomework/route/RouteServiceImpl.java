package com.finartz.ticketHomework.route;

import com.finartz.ticketHomework.dao.RouteDao;
import com.finartz.ticketHomework.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteDao routeDao;

    @Override
    public Optional<Route> getRouteById(Integer id) {
        return routeDao.findById(id);
    }
}
