package com.example.demo.hexagonal_architecture.core.port.out.in.association;

import com.example.demo.hexagonal_architecture.adapter.dto.association.AssociationDTO;
import com.example.demo.hexagonal_architecture.core.enitity.association.AssociationEntity;

import java.util.List;
import java.util.Optional;

public interface AssociationService {
    boolean checkSolution(Long associationId, String column, String userInput);
    boolean checkFinalSolution(Long associationId, String userInput);
    AssociationDTO saveAssociation(AssociationDTO associationDto);
    List<AssociationDTO> getAll();
    Optional<AssociationDTO> findById(Long id);
}
