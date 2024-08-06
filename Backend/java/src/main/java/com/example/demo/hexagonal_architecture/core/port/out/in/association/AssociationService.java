package com.example.demo.hexagonal_architecture.core.port.out.in.association;

import com.example.demo.hexagonal_architecture.adapter.dto.association.AssociationDTO;
import java.util.List;

public interface AssociationService {
    boolean checkSolution(Long associationId, String column, String userInput);
    boolean checkFinalSolution(Long associationId, String userInput);
    AssociationDTO saveAssociation(AssociationDTO associationDto);
    List<AssociationDTO> getAll();
}
