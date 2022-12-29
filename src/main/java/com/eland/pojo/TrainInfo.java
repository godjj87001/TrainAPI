package com.eland.pojo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrainInfo {

    private String trainDate;
    private int trainNo;
    private String departureTime;
    private String arrivalTime;
    private String travelTime;
    private String startingStationNameZhTw;
    private String ending_station_nameZhTw;
    private String trainTypenameZhTw;
    private String tripLine;
    private String startStation;
    private String endStation;

    @Override
    public String toString() {
        return "TrainInfo{" +
                "trainDate='" + trainDate + '\'' +
                ", trainNo=" + trainNo +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", travelTime='" + travelTime + '\'' +
                ", startingStationNameZhTw='" + startingStationNameZhTw + '\'' +
                ", ending_station_nameZhTw='" + ending_station_nameZhTw + '\'' +
                ", trainTypenameZhTw='" + trainTypenameZhTw + '\'' +
                ", tripLine='" + tripLine + '\'' +
                ", startStation='" + startStation + '\'' +
                ", endStation='" + endStation + '\'' +
                '}';
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(String trainDate) {
        this.trainDate = trainDate;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getStartingStationNameZhTw() {
        return startingStationNameZhTw;
    }

    public void setStartingStationNameZhTw(String startingStationNameZhTw) {
        this.startingStationNameZhTw = startingStationNameZhTw;
    }

    public String getEnding_station_nameZhTw() {
        return ending_station_nameZhTw;
    }

    public void setEnding_station_nameZhTw(String ending_station_nameZhTw) {
        this.ending_station_nameZhTw = ending_station_nameZhTw;
    }

    public String getTrainTypenameZhTw() {
        return trainTypenameZhTw;
    }

    public void setTrainTypenameZhTw(String trainTypenameZhTw) {
        this.trainTypenameZhTw = trainTypenameZhTw;
    }

    public String getTripLine() {
        return tripLine;
    }

    public void setTripLine(String tripLine) {
        this.tripLine = tripLine;
    }
}
