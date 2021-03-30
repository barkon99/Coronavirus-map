package com.konew.coronavirusextendsmap.parser;

import com.konew.coronavirusextendsmap.pojo.Coordinates;
import com.konew.coronavirusextendsmap.pojo.Data;
import com.konew.coronavirusextendsmap.pojo.DataResponse;
import com.konew.coronavirusextendsmap.pojo.LatestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;

class Covid19ParserTest
{
    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    Covid19Parser covid19Parser = new Covid19Parser(restTemplate);

    @Test
    public void shouldReturnCorrectList() {
        DataResponse dataResponse = new DataResponse();
        dataResponse.setDataList(Arrays.asList(new Data(
                new Coordinates(32.1, 12.3),
                "kraj",
                new LatestData(7823, "30567", 20000))));
        Mockito.when(restTemplate.getForObject(anyString(), anyObject()))
                .thenReturn(dataResponse);
        List<Data> actualData = covid19Parser.getData();
        Assertions.assertEquals(dataResponse.getDataList().size(), actualData.size());
    }
    @Test
    public void shouldReturnCorrectLengthListWhenOneCoordinatesAre0() {
        DataResponse dataResponse = new DataResponse();
        dataResponse.setDataList(Arrays.asList(new Data(
                new Coordinates(32.1, 12.3),
                "kraj",
                new LatestData(7823, "30567", 20000)),
                new Data(
                        new Coordinates(0, 0),
                        "kraj2",
                        new LatestData(7823, "30567", 20000))));
        Mockito.when(restTemplate.getForObject(anyString(), anyObject()))
                .thenReturn(dataResponse);
        List<Data> actualData = covid19Parser.getData();
        Assertions.assertEquals(dataResponse.getDataList().size() - 1, actualData.size());
    }

}
