package com.finartz.ticketHomework.dto;

public class RouteDto {
    private String code;
    private Integer fromAirportId;
    private Integer toAirportId;

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
