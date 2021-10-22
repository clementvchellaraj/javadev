package org.clmdev.controller;

import java.util.List;
import java.util.Optional;

import org.clmdev.entity.City;
import org.clmdev.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import io.opentracing.Span;
//import io.opentracing.Tracer;

@RestController
@RequestMapping("/city")
public class CityRestCRUDController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityRestCRUDController.class);
	private static final String version = "v1.0";
	@Autowired
	CityRepository cityRepository;

//	@Value("${eureka.instance.instance-id}")
//	private String instanceId;

//	 @Autowired
//	 private Tracer tracer;

	// service version
	@GetMapping("/version")
	public String version() {
		LOGGER.info("City version: v1.0");
		return version;
	}
	
	// insert new country into database
	@PostMapping("/add")
	public City addCity(@RequestBody City city,@RequestHeader HttpHeaders headers) {
		/*
		if (tracer == null) {
			System.out.println("*** CLEMENT - Tracer is NULL");
		}
		else {
		    Span span = tracer.buildSpan("clement-test").start();
		    span.finish();
		    }
		    */
		LOGGER.info("City addCity: city={}", city.objectToJson());
		return cityRepository.save(city);
	}

	// fetch all country list from database
	@GetMapping("/all")
	public Iterable<City> allCity(@RequestHeader HttpHeaders headers) {
		LOGGER.info("City allCity: city");
		return cityRepository.findAll();
	}

	// fetch specific country by their ID
	@GetMapping("/{cityId}")
	public Optional<City> cityById(@PathVariable("cityId") int cityId,@RequestHeader HttpHeaders headers) {
		LOGGER.info("City cityById: cityId={}", cityId);
		return cityRepository.findById(cityId);
	}
	
	// fetch specific city by their countryName
	@RequestMapping(method = RequestMethod.GET)
	public List<City> cityByCountryName(@RequestParam(value="countryName") String countryName,@RequestHeader HttpHeaders headers) {
		LOGGER.info("City cityByCountryName: countryName={}", countryName);
		// Print all headers
		for (String key : headers.keySet()) {
			System.out.println(" HttpHeaders ::" + key + "=" + headers.get(key));
		}
		return cityRepository.findByCountryNameIgnoreCase(countryName);
	}

	/*
	// fetch specific city by their Name
	@RequestMapping(method = RequestMethod.GET)
	public Optional<City> cityByName(@RequestParam(value="cityName") String cityName,@RequestHeader HttpHeaders headers) {
		LOGGER.info("City cityByName: cityName={}", cityName);
		return cityRepository.findByCityNameIgnoreCase(cityName);
	}
	*/

	// update existing city
	@PutMapping("/update")
	public City updateCity(@RequestBody City city,@RequestHeader HttpHeaders headers) {
		LOGGER.info("City updateCity: city={}", city.objectToJson());
		return cityRepository.save(city);
	}

	// delete country from database
	@DeleteMapping("/{cityId}")
	public void deleteCity(@PathVariable("cityId") int cityId,@RequestHeader HttpHeaders headers) {
		LOGGER.info("City deleteCity: city={}", cityId);
		cityRepository.deleteById(cityId);
	}
}

