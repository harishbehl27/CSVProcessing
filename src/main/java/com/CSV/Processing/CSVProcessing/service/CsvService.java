package com.CSV.Processing.CSVProcessing.service;

import com.CSV.Processing.CSVProcessing.model.City;
import com.CSV.Processing.CSVProcessing.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CsvService implements ICsvService{

    @Autowired
    private CityRepository cityRepository;

}


