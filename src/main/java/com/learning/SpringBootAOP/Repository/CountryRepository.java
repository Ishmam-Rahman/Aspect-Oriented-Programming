package com.learning.SpringBootAOP.Repository;

import com.learning.SpringBootAOP.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
