package com.cbarreto.iraolachallenge.controllers;

import com.cbarreto.iraolachallenge.models.Person;
import com.cbarreto.iraolachallenge.models.Relation;
import com.cbarreto.iraolachallenge.services.PersonService;
import com.cbarreto.iraolachallenge.services.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personas")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    RelationService relationService;

    @GetMapping()
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> data = personService.getAll().stream().distinct().collect(Collectors.toList());
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<Object> storePerson(@Valid @RequestBody Person personRequest) {

        Optional<Person> optionalPerson = personService.getPersonByDocumentNumber(personRequest.getDocumentNumber());
        if (optionalPerson.isPresent())
            return ResponseEntity.badRequest().body("There are already a user with that document number");

        return ResponseEntity.status(HttpStatus.CREATED).body(personService.savePerson(personRequest));
    }

    @GetMapping(path = "/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updatePerson(@Valid @RequestBody Person person, @PathVariable Long id) {
        Optional<Person> optionalPerson = personService.getPersonById(id);
        if (!optionalPerson.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Person not found");

        person.setId(id);
        return ResponseEntity.ok(personService.savePerson(person));
    }

    @DeleteMapping(path = "/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        return personService.deletePerson(id) ? "success" : "failed";
    }

    @GetMapping(path = "/byDocument/{documentNumber}")
    public Optional<Person> getPersonsByDocumentNumber(@PathVariable("documentNumber") Long documentNumber) {
        return personService.getPersonByDocumentNumber(documentNumber);
    }

    @PostMapping(path = "/{mainId}/{relation}/{secondId}")
    public ResponseEntity<Relation> relatePersons(
            @PathVariable Long mainId,
            @PathVariable String relation,
            @PathVariable Long secondId
    ) {
        return ResponseEntity.ok(relationService.saveRelation(new Relation(mainId, secondId, relation)));
    }

}
