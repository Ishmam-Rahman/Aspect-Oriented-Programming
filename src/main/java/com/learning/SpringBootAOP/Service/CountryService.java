package com.learning.SpringBootAOP.Service;

import com.learning.SpringBootAOP.Entity.Country;
import com.learning.SpringBootAOP.Repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
  private final CountryRepository countryRepository;


  public CountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  public Country findById(Long id) {
    return countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
  }
}
