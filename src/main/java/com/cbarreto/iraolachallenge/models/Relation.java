package com.cbarreto.iraolachallenge.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Locale;

@Data
@Entity
@Table(
        name = "relations",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_relation_mainId_secondId_relation",
                columnNames = {"main_id", "second_id", "relation"}
        )
)
public class Relation {

    public Relation() {

    }

    public Relation(Long mainId, long secondId, String relation) {
        this.mainId = mainId;
        this.secondId = secondId;
        this.relation = RelationType.valueOf(relation.toUpperCase());
    }

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "main_id")
    private Long mainId;

    @Column(name = "second_id")
    private Long secondId;

    @Enumerated(EnumType.STRING)
    private RelationType relation;
}