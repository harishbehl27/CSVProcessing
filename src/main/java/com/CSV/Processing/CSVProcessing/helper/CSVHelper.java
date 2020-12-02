package com.CSV.Processing.CSVProcessing.helper;

import com.CSV.Processing.CSVProcessing.model.City;
import com.CSV.Processing.CSVProcessing.repository.CityRepository;
import com.CSV.Processing.CSVProcessing.service.CsvService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CSVHelper {



    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Id", "name", "Population"};


    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }


    public static List<City> csvToCities(InputStream is) {

        List<City> cities= new ArrayList<>();

        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        ///### Approach  by creating list through streams

        return br.lines().skip(1).map(mapToItem).collect(Collectors.toList());

        //##### Approach by iteraring  the records

//        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//
//
//
//             CSVParser csvParser = new CSVParser(fileReader,
//                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
//
//
//
//            Iterable<CSVRecord> csvRecords=csvParser.getRecords();
//
//            for (CSVRecord csvRecord:csvRecords)
//            {
//
//                City city = new City();
//                city.setAreacode(Integer.parseInt(csvRecord.get(2)));
//                cities.add(city);
//                System.out.println("I am Harish");
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return cities;





    }


    private static Function<String, City> mapToItem = (line) ->{

        String[] p=line.split(",");
        City city = new City();


        city.setAreacode(Integer.parseInt(p[0]));


        return city;


    };
}

