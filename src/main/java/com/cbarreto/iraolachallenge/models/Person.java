package com.cbarreto.iraolachallenge.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(
        name = "persons",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_person_document_type_number",
                columnNames = {"document_type", "document_number"}
        )
)
public class Person {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_number")
    private long documentNumber;

    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    private String phone;

    @Column(name = "age")
    @Min(value = 18, message = "You must have more than 18 years to register")
    private Integer age;

}