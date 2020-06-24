package com.konew.coronavirusextendsmap.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private Coordinates coordinates;
    private String name;
    private LatestData latest_data;

    public Data() {
    }

    public Data(Coordinates coordinates, String name, LatestData latest_data) {
        this.coordinates = coordinates;
        this.name = name;
        this.latest_data = latest_data;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatestData getLatest_data() {
        return latest_data;
    }

    public void setLatest_data(LatestData latest_data) {
        this.latest_data = latest_data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "coordinates=" + coordinates +
                ", name='" + name + '\'' +
                ", latest_data=" + latest_data +
                '}';
    }
}


