package com.finartz.ticketHomework.entity;

import javax.persistence.*;

@Entity
public class Flight {

    @Id
    @Column
    @GeneratedValue()
    private Integer id;

    @Column
    private Integer routeId;

    @Column
    private Integer airlineId;

    @Column
    private Integer quota;

    @Column
    private Double price;

    public Integer getId() {
        return id;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer cuota) {
        this.quota = cuota;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
