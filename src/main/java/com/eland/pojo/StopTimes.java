package com.eland.pojo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class StopTimes {
    @JsonProperty("StopSequence")

    private int stopSequence;
    @JsonProperty("StationID")
    private int stationID;
    @JsonProperty("StationName")
    private StationName stationName;
    @JsonProperty("ArrivalTime")
    private String arrivalTime;
    @JsonProperty("DepartureTime")
    private String departureTime;
    @JsonProperty("SuspendedFlag")
    private int suspendedFlag;
    private String setTravelTime;

    public int getStopSequence() {
        return stopSequence;
    }

    public void setStopSequence(int stopSequence) {
        this.stopSequence = stopSequence;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public StationName getStationName() {
        return stationName;
    }

    public void setStationName(StationName stationName) {
        this.stationName = stationName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getSuspendedFlag() {
        return suspendedFlag;
    }

    public void setSuspendedFlag(int suspendedFlag) {
        this.suspendedFlag = suspendedFlag;
    }

    public String getSetTravelTime() {
        return setTravelTime;
    }
    public void setTravelTime(String 行駛時間) {
        this.setTravelTime = setTravelTime;
    }
}