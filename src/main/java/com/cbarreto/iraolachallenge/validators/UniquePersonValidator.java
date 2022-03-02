package com.cbarreto.iraolachallenge.validators;

import com.cbarreto.iraolachallenge.models.Person;
import com.cbarreto.iraolachallenge.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *  [WIP] I Try to make the validation of unique person, but I have an NullPointer before the validation
 *  after searching is seems to be a dependency injection error.
 *  CustomAnnotation @UniquePerson
 */
public class UniquePersonValidator implements ConstraintValidator<UniquePerson, Person> {



    @Autowired
    IPersonRepository iPersonRepository;

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        return iPersonRepository.findByDocumentNumber(person.getDocumentNumber()).isPresent();
    }
}