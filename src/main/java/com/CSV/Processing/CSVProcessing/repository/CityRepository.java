package com.CSV.Processing.CSVProcessing.repository;

import com.CSV.Processing.CSVProcessing.model.City;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {


}
