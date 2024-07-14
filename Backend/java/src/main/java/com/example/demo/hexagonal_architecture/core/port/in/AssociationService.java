package com.example.demo.hexagonal_architecture.core.port.in;

import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDto;

import java.util.List;

public interface AssociationService {

    AssociationDto saveAssociation(AssociationDto associationDto);

    List<AssociationDto> getAll();
}
