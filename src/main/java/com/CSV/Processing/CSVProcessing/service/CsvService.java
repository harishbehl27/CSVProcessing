package com.CSV.Processing.CSVProcessing.service;

import com.CSV.Processing.CSVProcessing.helper.CSVHelper;
import com.CSV.Processing.CSVProcessing.model.City;
import com.CSV.Processing.CSVProcessing.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class CsvService implements ICsvService{

    @Autowired
    private CityRepository cityRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvService.class);


    ///###Approach with Aync threads######

//    public List<City> save(MultipartFile file) throws Exception {
//        final long start = System.currentTimeMillis();
//
//        try {
//            List<City> cities= CSVHelper.csvToCities(file.getInputStream());
//
//            LOGGER.info("Saving a list of cars of size {} records", cities.size() + "file name is" + file.getOriginalFilename());
//            cityRepository.saveAll(cities);
//
//            LOGGER.info("Elapsed time: {}", (System.currentTimeMillis() - start));
//            return cities;
//
//        } catch (IOException e) {
//
//            LOGGER.error("Failed to parse CSV file {}", e);
//            throw new Exception("Failed to parse CSV file {}", e);
//        }
//
//
//    }

    @Async
    public CompletableFuture<List<City>> save(MultipartFile file) throws Exception {
        final long start = System.currentTimeMillis();

        try {
            List<City> cities= CSVHelper.csvToCities(file.getInputStream());

            LOGGER.info("Saving a list of cars of size {} records", cities.size() + "file name is" + file.getOriginalFilename());
            cityRepository.saveAll(cities);

            LOGGER.info("Elapsed time: {}", (System.currentTimeMillis() - start));
            return CompletableFuture.completedFuture(cities);

        } catch (IOException e) {

            LOGGER.error("Failed to parse CSV file {}" + file.getOriginalFilename(), e);
            throw new Exception("Failed to parse CSV file {}" + file.getOriginalFilename(), e);
        }


    }

    @Async
    public CompletableFuture<List<City>> getAllCars() {

        LOGGER.info("Request to get a list of cars");
        final List<City> cities = cityRepository.findAll();
        return CompletableFuture.completedFuture(cities);
    }

}


