package com.konew.coronavirusextendsmap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.konew.coronavirusextendsmap.parser.Covid19Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DateController
{
    Covid19Parser covid19Parser;
    
    @Autowired
    public DateController(Covid19Parser covid19Parser) {
        this.covid19Parser = covid19Parser;
    }

    @GetMapping
    public String getData(Model model) {
        model.addAttribute("data",covid19Parser.getData());

        return "map";
    }


}
