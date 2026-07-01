package com.example.demo.controller;

import com.example.demo.Services.CountryService;
import com.example.demo.exception.CountryNotFoundException;
import com.example.demo.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getCountries(){

        return ResponseEntity.ok(countryService.getAllCountries());

    }

    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountry(@PathVariable String code){

        Country country=countryService.getCountry(code);

        if(country==null){
            throw new CountryNotFoundException("Country not found : "+code);
        }

        return ResponseEntity.ok(country);

    }

    @PostMapping
    public ResponseEntity<String> addCountry(@RequestBody Country country){

        countryService.addCountry(country);

        return new ResponseEntity<>("Country Added Successfully",
                HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<String> updateCountry(@RequestBody Country country){

        countryService.updateCountry(country);

        return ResponseEntity.ok("Country Updated Successfully");

    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCountry(@PathVariable String code){

        countryService.deleteCountry(code);

        return ResponseEntity.ok("Country Deleted Successfully");

    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Country>> search(@PathVariable String name){

        return ResponseEntity.ok(countryService.searchCountry(name));

    }

    @GetMapping("/starts/{prefix}")
    public ResponseEntity<List<Country>> starts(@PathVariable String prefix){

        return ResponseEntity.ok(countryService.getCountryStartsWith(prefix));

    }

    @GetMapping("/ends/{suffix}")
    public ResponseEntity<List<Country>> ends(@PathVariable String suffix){

        return ResponseEntity.ok(countryService.getCountryEndsWith(suffix));

    }

    @GetMapping("/contains/{text}")
    public ResponseEntity<List<Country>> contains(@PathVariable String text){

        return ResponseEntity.ok(countryService.getCountryContains(text));

    }

}