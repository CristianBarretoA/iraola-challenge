package com.cbarreto.iraolachallenge.repositories;

import com.cbarreto.iraolachallenge.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByDocumentNumber(Long documentNumber);
}
