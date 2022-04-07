package com.learning.SpringBootAOP.Controller;

import com.learning.SpringBootAOP.Entity.Country;
import com.learning.SpringBootAOP.Service.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class CountryController {

  private final CountryService countryService;

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping("/find-by-id/{id}")
  public Country findById(@PathVariable Long id) {
    return countryService.findById(id);
  }
}
