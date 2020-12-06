package com.CSV.Processing.CSVProcessing.controllers;

import com.CSV.Processing.CSVProcessing.helper.CSVHelper;
import com.CSV.Processing.CSVProcessing.message.ResponseMessage;
import com.CSV.Processing.CSVProcessing.service.CsvService;
import com.CSV.Processing.CSVProcessing.service.ICsvService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/api/csv")
public class MyCsvController {

    @Autowired
    CsvService csvService;

    Logger logger = LoggerFactory.getLogger(MyCsvController.class);


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadCsvData(@RequestParam(value = "file") MultipartFile file) {

        String message = "";

            if (CSVHelper.hasCSVFormat(file)) {
                try {
                    csvService.save(file);

                    message = "Uploaded the file successfully" + file.getOriginalFilename();
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

                } catch (Exception e) {
                    message = "Could not upload the file successfully" + file.getOriginalFilename();
                    logger.error("Error" + e);
                    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
                }



        }


            message = "Please upload a valid csv file ";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));


        }





        @GetMapping("/wordgrid")
        public String getHello (@RequestParam String wordList){
            return wordList;
        }


    }
