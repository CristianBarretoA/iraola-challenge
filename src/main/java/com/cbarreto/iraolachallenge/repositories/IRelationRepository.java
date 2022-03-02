package com.cbarreto.iraolachallenge.repositories;

import com.cbarreto.iraolachallenge.models.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRelationRepository extends JpaRepository<Relation, Long> {

    Relation findByMainIdAndSecondId(Long mainId, Long secondId);

}
