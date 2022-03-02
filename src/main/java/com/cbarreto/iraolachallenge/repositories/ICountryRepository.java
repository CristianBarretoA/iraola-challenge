package com.cbarreto.iraolachallenge.repositories;

import com.cbarreto.iraolachallenge.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country, Long> {

}
