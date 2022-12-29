package com.eland.pojo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyTrainInfo {
    @JsonProperty("TrainNo")
    private int trainNo;
    @JsonProperty("Direction")
    private int direction;
    @JsonProperty("StartingStationID")
    private int startingStationID;
    @JsonProperty("StartingStationName")
    private StartingStationName startingStationName;
    @JsonProperty("EndingStationID")
    private int endingStationID;
    @JsonProperty("EndingStationName")
    private EndingStationName endingStationName;
    @JsonProperty("TrainTypeID")
    private String trainTypeID;
    @JsonProperty("TrainTypeCode")
    private int trainTypeCode;
    @JsonProperty("TrainTypeName")
    private TrainTypeName trainTypeName;
    @JsonProperty("TripLine")
    private int tripLine;
    @JsonProperty("WheelchairFlag")
    private int wheelchairFlag;
    @JsonProperty("PackageServiceFlag")
    private int packageServiceFlag;
    @JsonProperty("DiningFlag")
    private int diningFlag;
    @JsonProperty("BikeFlag")
    private int bikeFlag;
    @JsonProperty("BreastFeedingFlag")
    private int breastFeedingFlag;
    @JsonProperty("DailyFlag")
    private int dailyFlag;
    @JsonProperty("ServiceAddedFlag")
    private int serviceAddedFlag;
    @JsonProperty("SuspendedFlag")
    private int suspendedFlag;
    @JsonProperty("Note")
    private Note note;
    @JsonProperty("OverNightStationID")
    private String overNightStationID;

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getStartingStationID() {
        return startingStationID;
    }

    public void setStartingStationID(int startingStationID) {
        this.startingStationID = startingStationID;
    }

    public StartingStationName getStartingStationName() {
        return startingStationName;
    }

    public void setStartingStationName(StartingStationName startingStationName) {
        this.startingStationName = startingStationName;
    }

    public int getEndingStationID() {
        return endingStationID;
    }

    public void setEndingStationID(int endingStationID) {
        this.endingStationID = endingStationID;
    }

    public EndingStationName getEndingStationName() {
        return endingStationName;
    }

    public void setEndingStationName(EndingStationName endingStationName) {
        this.endingStationName = endingStationName;
    }

    public String getTrainTypeID() {
        return trainTypeID;
    }

    public void setTrainTypeID(String trainTypeID) {
        this.trainTypeID = trainTypeID;
    }

    public int getTrainTypeCode() {
        return trainTypeCode;
    }

    public void setTrainTypeCode(int trainTypeCode) {
        this.trainTypeCode = trainTypeCode;
    }

    public TrainTypeName getTrainTypeName() {
        return trainTypeName;
    }

    public void setTrainTypeName(TrainTypeName trainTypeName) {
        this.trainTypeName = trainTypeName;
    }

    public int getTripLine() {
        return tripLine;
    }

    public void setTripLine(int tripLine) {
        this.tripLine = tripLine;
    }

    public int getWheelchairFlag() {
        return wheelchairFlag;
    }

    public void setWheelchairFlag(int wheelchairFlag) {
        this.wheelchairFlag = wheelchairFlag;
    }

    public int getPackageServiceFlag() {
        return packageServiceFlag;
    }

    public void setPackageServiceFlag(int packageServiceFlag) {
        this.packageServiceFlag = packageServiceFlag;
    }

    public int getDiningFlag() {
        return diningFlag;
    }

    public void setDiningFlag(int diningFlag) {
        this.diningFlag = diningFlag;
    }

    public int getBikeFlag() {
        return bikeFlag;
    }

    public void setBikeFlag(int bikeFlag) {
        this.bikeFlag = bikeFlag;
    }

    public int getBreastFeedingFlag() {
        return breastFeedingFlag;
    }

    public void setBreastFeedingFlag(int breastFeedingFlag) {
        this.breastFeedingFlag = breastFeedingFlag;
    }

    public int getDailyFlag() {
        return dailyFlag;
    }

    public void setDailyFlag(int dailyFlag) {
        this.dailyFlag = dailyFlag;
    }

    public int getServiceAddedFlag() {
        return serviceAddedFlag;
    }

    public void setServiceAddedFlag(int serviceAddedFlag) {
        this.serviceAddedFlag = serviceAddedFlag;
    }

    public int getSuspendedFlag() {
        return suspendedFlag;
    }

    public void setSuspendedFlag(int suspendedFlag) {
        this.suspendedFlag = suspendedFlag;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getOverNightStationID() {
        return overNightStationID;
    }

    public void setOverNightStationID(String overNightStationID) {
        this.overNightStationID = overNightStationID;
    }
}