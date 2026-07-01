package com.example.demo.Services;

import com.example.demo.exception.CountryNotFoundException;
import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(String code) {

        Country country = countryRepository.findByCode(code);

        if(country==null){
            throw new CountryNotFoundException("Country not found : "+code);
        }

        return country;
    }

    public void addCountry(Country country){
        countryRepository.save(country);
    }

    public void updateCountry(Country country){
        countryRepository.save(country);
    }

    public void deleteCountry(String code){
        countryRepository.deleteByCode(code);
    }

    public List<Country> searchCountry(String text){
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(text);
    }

    public List<Country> getCountryStartsWith(String prefix){
        return countryRepository.findByNameStartingWithIgnoreCase(prefix);
    }

    public List<Country> getCountryEndsWith(String suffix){
        return countryRepository.findByNameEndingWithIgnoreCase(suffix);
    }

    public List<Country> getCountryContains(String text){
        return countryRepository.findByNameContainingIgnoreCase(text);
    }
}