package com.konew.coronavirusextendsmap.parser;

import com.konew.coronavirusextendsmap.pojo.Data;
import com.konew.coronavirusextendsmap.pojo.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Covid19Parser
{
    RestTemplate restTemplate;

    @Autowired
    public Covid19Parser(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private  static final  String url = "https://corona-api.com/countries";

    public List<Data> getData() {
        System.setProperty("http.agent", "Chrome");
        List<Data> data = restTemplate.getForObject(url, DataResponse.class).getDataList();
        List<Data> filteredData = data.stream()
                .filter(data1 -> (data1.getCoordinates().getLongitude()!=0 && data1.getCoordinates().getLatitude()!=0))
                .collect(Collectors.toList());

        return filteredData;
    }
}
