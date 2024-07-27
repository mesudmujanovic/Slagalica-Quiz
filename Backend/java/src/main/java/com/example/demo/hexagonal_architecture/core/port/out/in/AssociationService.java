package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDTO;
import java.util.List;

public interface AssociationService {
    boolean checkSolution (Long associationId, String column, String userInput);
    AssociationDTO saveAssociation (AssociationDTO associationDto);
    List<AssociationDTO> getAll ();
}
