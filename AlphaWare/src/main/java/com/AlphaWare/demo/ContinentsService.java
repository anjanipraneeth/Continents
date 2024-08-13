package com.AlphaWare.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContinentsService {
	
	@Autowired
	private ContinentRepository continentRepository; 
	
	   @Value("${api.url}")
	    private String apiUrl;

	   	@Autowired
	     RestTemplate restTemplate;

	

	    public ContinentDTO[] retrieveData() {
	        try {
	            ContinentDTO[] continentDTOs = restTemplate.getForObject(apiUrl, ContinentDTO[].class);

	            if (continentDTOs != null && continentDTOs.length > 0) {
	                return continentDTOs;
	            } else {
	                throw new NoDataFoundException("No data found from the API.");
	            }
	        } catch (NoDataFoundException e) {
	            throw e; 
	        } catch (Exception e) {
	            throw new NoDataFoundException("Error retrieving data from the API."); 
	        }
	    }

	    
	    
	    public void saveData(ContinentDTO[] dtos) {
	        if (dtos != null) {
	            try {
	                for (ContinentDTO dto : dtos) {
	                    Continent continent = new Continent();
	                    continent.setCode(dto.getCode());
	                    continent.setName(dto.getName());
	                    continent.setAreaSqKm(dto.getAreaSqKm());
	                    continent.setPopulation(dto.getPopulation());
	                    continent.setLines(dto.getLines());
	                    continent.setCountries(dto.getCountries());
	                    continent.setOceans(dto.getOceans());
	                    continent.setDevelopedCountries(dto.getDevelopedCountries());

	                    continentRepository.save(continent);
	                }
	            } catch (Exception e) {
	                // Handle the exception, such as logging or rethrowing it as a custom exception
	                throw new   NoDataFoundException("Error saving continent data: ");
	            }
	        } else {
	            throw new NoDataFoundException("Input DTO array is null or empty.");
	        }
	    }
}
