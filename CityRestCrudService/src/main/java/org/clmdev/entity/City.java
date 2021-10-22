package org.clmdev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "city_master")
public class City {

	// TODO: Generate getters and setters...

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "city_id")
	private int cityId;

	@Column(name = "city_name")
	private String cityName;
	
	@Column(name = "country_name")
	private String countryName;

	@Column(name = "city_total_counties")
	private int cityTotalCounties;

	@Column(name = "city_population")
	private int cityPopulation;
	
	@Column(name = "city_recorded_high_temp")
	private double cityRecordedHighTemp;

	@Column(name = "city_recorded_low_temp")
	private double cityRecordedLowTemp;
	
	@Column(name = "city_annual_precipitation")
	private double cityAnnualPrecipitation;
	
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName.toUpperCase();
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName.toUpperCase();
	}

	public int getCityTotalCounties() {
		return cityTotalCounties;
	}

	public void setCityTotalCounties(int cityTotalCounties) {
		this.cityTotalCounties = cityTotalCounties;
	}

	public int getCityPopulation() {
		return cityPopulation;
	}

	public void setCityPopulation(int cityPopulation) {
		this.cityPopulation = cityPopulation;
	}

	public double getCityRecordedHighTemp() {
		return cityRecordedHighTemp;
	}

	public void setCityRecordedHighTemp(double cityRecordedHighTemp) {
		this.cityRecordedHighTemp = cityRecordedHighTemp;
	}

	public double getCityRecordedLowTemp() {
		return cityRecordedLowTemp;
	}

	public void setCityRecordedLowTemp(double cityRecordedLowTemp) {
		this.cityRecordedLowTemp = cityRecordedLowTemp;
	}

	public double getCityAnnualPrecipitation() {
		return cityAnnualPrecipitation;
	}

	public void setCityAnnualPrecipitation(double cityAnnualPrecipitation) {
		this.cityAnnualPrecipitation = cityAnnualPrecipitation;
	}
	
	public String objectToJson() {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        	return json;
	}

}
