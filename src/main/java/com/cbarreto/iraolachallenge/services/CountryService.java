package com.cbarreto.iraolachallenge.services;

import com.cbarreto.iraolachallenge.models.Country;
import com.cbarreto.iraolachallenge.repositories.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    ICountryRepository iCountryRepository;

    public Country save(Country country) {
        return iCountryRepository.save(country);
    }

    public Long count() {
        return iCountryRepository.count();
    }
}
