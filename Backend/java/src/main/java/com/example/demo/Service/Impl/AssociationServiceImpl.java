package com.example.demo.Service.Impl;

import com.example.demo.Enitity.AssociationEntity;
import com.example.demo.Repo.AssociationRepo;
import com.example.demo.Service.AssociationService;
import com.example.demo.infrastucture.Mapper.AssociationDtoMapper;
import com.example.demo.infrastucture.Mapper.AssociationMapper;
import com.example.demo.infrastucture.dto.AssociationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class AssociationServiceImpl implements AssociationService {

    @Autowired
    private AssociationRepo associationRepo;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public AssociationDto saveAssociation(AssociationDto associationDto) {
        AssociationEntity associationEntity = AssociationMapper.INSTANCE.apply(associationDto);
        AssociationEntity associationEntitySave = associationRepo.save(associationEntity);
        return AssociationDtoMapper.INSTANCE.apply(associationEntitySave);
    }

    @Override
    @Transactional
    public List<AssociationDto> getAll() {
        List<AssociationEntity> associationEntities = associationRepo.findAll();
        return associationEntities.stream()
                .map(AssociationDtoMapper.INSTANCE::apply)
                .collect(Collectors.toList());
    }


}
