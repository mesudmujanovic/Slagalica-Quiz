package com.example.demo.Service;

import com.example.demo.infrastucture.dto.AssociationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssociationService {

    AssociationDto saveAssociation(AssociationDto associationDto);

    List<AssociationDto> getAll();
}
