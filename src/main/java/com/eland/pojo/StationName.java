package com.eland.pojo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StationName {

    @JsonProperty("Zh_tw")
    private String zh_tw;
    @JsonProperty("En")
    private String en;

    public StationName() {
    }

    public StationName(String en, String zh_tw) {
        this.en = getEn();
        this.zh_tw = getZh_tw();
    }

    public String getZh_tw() {
        return zh_tw;
    }

    public void setZh_tw(String zh_tw) {
        this.zh_tw = zh_tw;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

}