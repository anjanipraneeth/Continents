package com.AlphaWare.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContinentsController {
	
	@Autowired
	ContinentsService continentsService;
	    @GetMapping("/getAll")
	    public ContinentDTO[] getContinents() {
	        return continentsService.retrieveData();
	    }
	    @PostMapping("/save")
	    public String saveData(@RequestBody ContinentDTO[] continentDTOs) {
	        continentsService.saveData(continentDTOs);
	        return "Data saved successfully.";
	    }

}
