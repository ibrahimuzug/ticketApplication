package com.finartz.ticketHomework.entity;

import javax.persistence.*;

@Entity
public class Route {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String code;

    @Column
    private Integer fromAirportId;

    @Column
    private Integer toAirportId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getFromAirportId() {
        return fromAirportId;
    }

    public void setFromAirportId(Integer fromAirportId) {
        this.fromAirportId = fromAirportId;
    }

    public Integer getToAirportId() {
        return toAirportId;
    }

    public void setToAirportId(Integer toAirportId) {
        this.toAirportId = toAirportId;
    }
}
