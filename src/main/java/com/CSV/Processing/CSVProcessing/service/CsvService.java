package com.CSV.Processing.CSVProcessing.service;

import com.CSV.Processing.CSVProcessing.helper.CSVHelper;
import com.CSV.Processing.CSVProcessing.model.City;
import com.CSV.Processing.CSVProcessing.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class CsvService implements ICsvService{

    @Autowired
    private CityRepository cityRepository;



    public void save(MultipartFile file)
    {
        try {
            List<City> cities= CSVHelper.csvToCities(file.getInputStream());
            cityRepository.saveAll(cities);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}


