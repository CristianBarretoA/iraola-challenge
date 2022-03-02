package com.cbarreto.iraolachallenge.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "countries")
public class Country {

    public Country() {

    }

    public Country(String name) {
        this.name = name;
    }

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


}
