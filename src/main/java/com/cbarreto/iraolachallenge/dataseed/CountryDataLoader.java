package com.cbarreto.iraolachallenge.dataseed;

import com.cbarreto.iraolachallenge.models.Country;
import com.cbarreto.iraolachallenge.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CountryDataLoader implements CommandLineRunner {

    @Autowired
    CountryService countryService;


    @Override
    public void run(String... args) throws Exception {
        loadPersonData();
    }

    private void loadPersonData() {
        if (countryService.count() == 0) {
            countryService.save(new Country("COLOMBIA"));
            countryService.save(new Country("ARGENTINA"));
            countryService.save(new Country("MEXICO"));
            countryService.save(new Country("PERU"));
            countryService.save(new Country("CHILE"));
        }
        System.out.println(countryService.count());
    }
}
