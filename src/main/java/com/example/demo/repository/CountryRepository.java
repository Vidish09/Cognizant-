package com.example.demo.repository;

import com.example.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,String> {

    Country findByCode(String code);

    void deleteByCode(String code);

    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    List<Country> findByNameStartingWithIgnoreCase(String prefix);

    List<Country> findByNameEndingWithIgnoreCase(String suffix);

    List<Country> findByNameContainingIgnoreCase(String text);

}