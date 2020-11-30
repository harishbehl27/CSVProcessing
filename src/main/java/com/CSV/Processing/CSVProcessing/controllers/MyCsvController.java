package com.CSV.Processing.CSVProcessing.controllers;

import com.CSV.Processing.CSVProcessing.service.ICsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MyCsvController {

    @Autowired
    ICsvService iCsvService;


    @RequestMapping(value="/uploadCsv")
    public void uploadCsvData(HttpServletRequest request)
    {

    }

}
