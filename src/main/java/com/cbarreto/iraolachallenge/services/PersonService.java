package com.cbarreto.iraolachallenge.services;

import com.cbarreto.iraolachallenge.models.GenderType;
import com.cbarreto.iraolachallenge.models.Person;
import com.cbarreto.iraolachallenge.repositories.IPersonRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Validator;
import java.util.*;


@Service
@Validated
public class PersonService {

    @Autowired
    IPersonRepository iPersonRepository;

    @Autowired
    Validator validator;

    public ArrayList<Person> getAll() {
        return (ArrayList<Person>) iPersonRepository.findAll();
    }

    public Person savePerson(Person person) throws ConstraintViolationException {
        return iPersonRepository.save(person);
    }

    public Optional<Person> getPersonById(Long id) {
        return iPersonRepository.findById(id);
    }

    public boolean deletePerson(Long id) {
        try {
            iPersonRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public Optional<Person> getPersonByDocumentNumber(Long documentNumber) {
        return iPersonRepository.findByDocumentNumber(documentNumber);
    }

    public Map<String, Long> getPersonStatistics() {
        Map<String, Long> response = new HashMap<>();
        List<Person> personList = iPersonRepository.findAll();
        response.put("cantidad_mujeres", getTotalByGender(personList, GenderType.MUJER));
        response.put("cantidad_hombres", getTotalByGender(personList, GenderType.HOMBRE));
        response.put("porcentaje_argentinos", getTotalByCountry(personList, 2L));
        return response;
    }



    private long getTotalByGender(List<Person> personList, GenderType gender) {
        return personList.stream()
                .filter(person -> person.getGender().equals(gender))
                .count();
    }

    private long getTotalByCountry(List<Person> personList, Long countryId) {
        return personList.stream()
                .filter(person -> person.getCountry().getId() == countryId)
                .count();
    }

}
