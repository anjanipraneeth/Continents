package com.AlphaWare.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "continent")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "area_sq_km")
    private long areaSqKm;

    @Column(name = "population")
    private long population;

    @Column(name = "lines")
    private String lines;

    @Column(name = "countries")
    private int countries;

    @Column(name = "oceans")
    private String oceans;

    @Column(name = "developed_countries")
    private String developedCountries;

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAreaSqKm() {
        return areaSqKm;
    }

    public void setAreaSqKm(long areaSqKm) {
        this.areaSqKm = areaSqKm;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public List<String> getLines() {
        return convertStringToList(lines);
    }

    public void setLines(List<String> lines) {
        this.lines = convertListToString(lines);
    }

    public int getCountries() {
        return countries;
    }

    public void setCountries(int countries) {
        this.countries = countries;
    }

    public List<String> getOceans() {
        return convertStringToList(oceans);
    }

    public void setOceans(List<String> oceans) {
        this.oceans = convertListToString(oceans);
    }

    public List<String> getDevelopedCountries() {
        return convertStringToList(developedCountries);
    }

    public void setDevelopedCountries(List<String> developedCountries) {
        this.developedCountries = convertListToString(developedCountries);
    }

 
    private List<String> convertStringToList(String data) {
        if (data == null || data.isEmpty()) {
            return new ArrayList<>();
        }
        String[] items = data.split(",");
        return new ArrayList<>(Arrays.asList(items));
    }

 
    private String convertListToString(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(item);
        }
        return sb.toString();
    }
}
