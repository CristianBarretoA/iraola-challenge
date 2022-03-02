package com.cbarreto.iraolachallenge.services;

import com.cbarreto.iraolachallenge.models.Relation;
import com.cbarreto.iraolachallenge.repositories.IRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelationService {

    @Autowired
    IRelationRepository iRelationRepository;

    public Relation saveRelation(Relation relation) {
        return iRelationRepository.save(relation);
    }

    public Object getRelationByIds(Long mainId, Long secondId) {
        Optional<Relation> optionalRelation = Optional.ofNullable(iRelationRepository.findByMainIdAndSecondId(mainId, secondId));

        if (optionalRelation.isEmpty())
            return "The users does not have a relation yet";

        return iRelationRepository.findByMainIdAndSecondId(mainId, secondId);

    }
}
