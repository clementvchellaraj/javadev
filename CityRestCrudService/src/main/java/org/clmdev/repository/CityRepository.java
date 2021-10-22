package org.clmdev.repository;

import java.util.List;
import java.util.Optional;

import org.clmdev.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {

	Optional<City> findByCityNameIgnoreCase(String cityName);
	List<City> findByCountryNameIgnoreCase(String countryName);
}
