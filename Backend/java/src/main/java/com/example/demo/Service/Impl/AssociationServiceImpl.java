package com.example.demo.Service.Impl;

import com.example.demo.Enitity.AssociationEntity;
import com.example.demo.Repo.AssociationRepo;
import com.example.demo.Service.AssociationService;
import com.example.demo.infrastucture.Mapper.AssociationDtoMapper;
import com.example.demo.infrastucture.Mapper.AssociationMapper;
import com.example.demo.infrastucture.dto.AssociationDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepo associationRepo;
    private final AssociationDtoMapper associationDtoMapper;
    private final AssociationMapper associationMapper;

    @Override
    public AssociationDto saveAssociation(AssociationDto associationDto) {
        AssociationEntity associationEntity = associationMapper.apply(associationDto);
        AssociationEntity associationEntitySave = associationRepo.save(associationEntity);
        return associationDtoMapper.apply(associationEntitySave);
    }

    @Override
    @Transactional
    public List<AssociationDto> getAll() {
        List<AssociationEntity> associationEntities = associationRepo.findAll();
        return associationEntities.stream()
                .map(associationDtoMapper::apply)
                .collect(Collectors.toList());
    }
}