package org.clmdev.repository;

import java.util.List;
import java.util.Optional;

import org.clmdev.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {

	Optional<Country> findByCountryNameIgnoreCase(String countryName);
}
