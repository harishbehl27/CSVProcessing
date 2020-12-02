package com.CSV.Processing.CSVProcessing.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="city")
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int areacode;

    public City() {

    }

    public Long getId() {
        return id;
    }


    public int getAreacode() {
        return areacode;
    }

    public void setAreacode(int areacode) {
        this.areacode = areacode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return areacode == city.areacode &&
                Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, areacode);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", areacode=" + areacode +
                '}';
    }
}
