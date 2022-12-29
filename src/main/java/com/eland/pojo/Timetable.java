package com.eland.pojo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class Timetable {

    // 其他成員
    @JsonProperty("TrainDate")
    private String trainDate;
    @JsonProperty("DailyTrainInfo")
    private DailyTrainInfo dailyTrainInfo;
    @JsonProperty("StopTimes")
    private List<StopTimes> stopTimes;
    @JsonProperty("UpdateTime")
    private String updateTime;
    @JsonProperty("VersionID")
    private int versionID;

    public Timetable() {
    }

    public Timetable(List<StopTimes> stopTimes) {
        this.stopTimes = stopTimes;
    }

    public String getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(String trainDate) {
        this.trainDate = trainDate;
    }

    public DailyTrainInfo getDailyTrainInfo() {
        return dailyTrainInfo;
    }

    public void setDailyTrainInfo(DailyTrainInfo dailyTrainInfo) {
        this.dailyTrainInfo = dailyTrainInfo;
    }

    public List<StopTimes> getStopTimes() {
        return stopTimes;
    }

    public void setStopTimes(List<StopTimes> stopTimes) {
        this.stopTimes = stopTimes;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "trainDate='" + trainDate + '\'' +
                ", dailyTrainInfo=" + dailyTrainInfo +
                ", stopTimes=" + stopTimes +
                ", updateTime='" + updateTime + '\'' +
                ", versionID=" + versionID +
                '}';
    }
}
