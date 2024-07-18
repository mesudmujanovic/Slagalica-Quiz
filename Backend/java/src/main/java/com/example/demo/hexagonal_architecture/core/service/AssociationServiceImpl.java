package com.example.demo.hexagonal_architecture.core.service;

import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.port.out.AssociationRepository;
import com.example.demo.hexagonal_architecture.core.port.out.in.AssociationService;
import com.example.demo.hexagonal_architecture.adapter.mapperDto.AssociationDtoMapper;
import com.example.demo.hexagonal_architecture.adapter.mapper.AssociationMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepository associationRepo;
    private final AssociationDtoMapper associationDtoMapper;
    private final AssociationMapper associationMapper;

    @Override
    public AssociationDto saveAssociation(AssociationDto associationDto) {
        AssociationEntity associationEntity = associationMapper.apply(associationDto);
        AssociationEntity associationEntitySave = associationRepo.saveAssociation(associationEntity);
        return associationDtoMapper.apply(associationEntitySave);
    }

    @Override
    @Transactional
    public List<AssociationDto> getAll() {
        List<AssociationEntity> associationEntities = associationRepo.getAll();
        return associationEntities.stream()
                .map(associationDtoMapper::apply)
                .collect(Collectors.toList());
    }
}