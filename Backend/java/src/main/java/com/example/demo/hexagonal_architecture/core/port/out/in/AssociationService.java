package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDTO;
import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;

import java.util.List;
import java.util.Optional;

public interface AssociationService {

    AssociationDTO saveAssociation(AssociationDTO associationDto);
    List<AssociationDTO> getAll();
    Optional<FieldDTO> getFieldByPosition(String position);
}
