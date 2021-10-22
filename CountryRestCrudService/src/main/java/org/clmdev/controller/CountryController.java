package org.clmdev.controller;

import java.util.Optional;

import org.clmdev.entity.Country;
import org.clmdev.repository.CountryRepository;
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

@RestController
@RequestMapping("/country")
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	private static final String version = "v1.0";
	
	@Autowired
	CountryRepository countryRepository;
	
	//@Value("${eureka.instance.instance-id}")
	//private String instanceId;
	
	// service version
	@GetMapping("/version")
	public String version(@RequestHeader HttpHeaders headers) {
		LOGGER.info("Country version: v1.0");
		return version;
	}
	
	// insert new country into database
	@PostMapping("/add")
	public Country addCountry(@RequestBody Country country,@RequestHeader HttpHeaders headers) {
		LOGGER.info("Country addCountry");
		return countryRepository.save(country);
	}

	// fetch all country list from database
	@GetMapping("/all")
	public Iterable<Country> allCountry(@RequestHeader HttpHeaders headers) {
		LOGGER.info("Country allCountry");
		return countryRepository.findAll();
	}

	// fetch specific country by their ID
	@GetMapping("/{countryId}")
	public Optional<Country> countryById(@PathVariable("countryId") int countryId,@RequestHeader HttpHeaders headers) {
		LOGGER.info("Country countryById: countryId={}", countryId);
		return countryRepository.findById(countryId);
	}
	
	// fetch specific country by their countryName
	@RequestMapping(method = RequestMethod.GET)
	public Optional<CountryDTO> countryByCountryName(@RequestParam(value="countryName") String countryName,@RequestHeader HttpHeaders headers) {
		LOGGER.info("Country countryByCountryName: countryName={}", countryName);
		Optional<Country> c = countryRepository.findByCountryNameIgnoreCase(countryName);
		CountryDTO dto = new CountryDTO();
		if (c.isPresent()) {
			Country ctr = c.get();
			dto.setCountryId(ctr.getCountryId());
			dto.setCountryLang(ctr.getCountryLang());
			dto.setCountryName(ctr.getCountryName());
			dto.setCountryPopulation(ctr.getCountryPopulation());
			dto.setVersion(version);
		}
		return Optional.of(dto);
	}
	

	// update existing country
	@PutMapping("/update")
	public Country updateCountry(@RequestBody Country country,@RequestHeader HttpHeaders headers) {
		LOGGER.info("Country updateCountry");
		return countryRepository.save(country);
	}

	// delete country from database
	@DeleteMapping("/{countryId}")
	public void deleteCountry(@PathVariable("countryId") int countryId,@RequestHeader HttpHeaders headers) {
		LOGGER.info("Country deleteCountry: countryId={}", countryId);
		countryRepository.deleteById(countryId);
	}
}
