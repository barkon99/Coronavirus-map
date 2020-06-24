package com.konew.coronavirusextendsmap.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DataResponse
{
    @JsonProperty("data")
    private List<Data> dataList;

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}
