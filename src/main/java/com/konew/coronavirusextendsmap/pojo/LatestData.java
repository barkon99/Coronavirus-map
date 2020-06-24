package com.konew.coronavirusextendsmap.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestData
{
    private int deaths;
    private String confirmed;
    private int recovered;

    public LatestData() {
    }

    public LatestData(int deaths, String confirmed, int recovered) {
        this.deaths = deaths;
        this.confirmed = confirmed;
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    @Override
    public String toString() {
        return "Latest_Data{" +
                "deaths=" + deaths +
                ", confirmed=" + confirmed +
                ", recovered=" + recovered +
                '}';
    }
}
