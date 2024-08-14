package com.example.demo.hexagonal_architecture.core.service.association;

import com.example.demo.hexagonal_architecture.core.enitity.association.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.exception.CorrectSolutionException;
import com.example.demo.hexagonal_architecture.core.exception.IncorrectSolutionException;
import com.example.demo.hexagonal_architecture.core.port.out.AssociationRepository;
import com.example.demo.hexagonal_architecture.core.port.out.in.association.AssociationService;
import com.example.demo.hexagonal_architecture.adapter.mapperDto.association.AssociationDtoMapper;
import com.example.demo.hexagonal_architecture.adapter.mapper.association.AssociationMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.association.AssociationDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepository associationRepo;
    private final AssociationDtoMapper associationDtoMapper;
    private final AssociationMapper associationMapper;

    @Override
    public AssociationDTO saveAssociation(AssociationDTO associationDto) {
        AssociationEntity associationEntity = associationMapper.apply(associationDto);
        AssociationEntity savedAssociationEntity = associationRepo.saveAssociation(associationEntity);
        return associationDtoMapper.apply(savedAssociationEntity);
    }

    @Override
    public List<AssociationDTO> getAll() {
        List<AssociationEntity> associationEntities = associationRepo.getAll();
        return associationEntities.stream()
                .map(associationDtoMapper::apply)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AssociationDTO> findById(Long id) {
        Optional<AssociationEntity> associationEntity = associationRepo.findById(id);
        Optional<AssociationDTO> associationDTO = associationEntity.map(associationDtoMapper::apply);
        return associationDTO;
    }

    @Override
    public boolean checkSolution(Long associationId, String column, String userInput) {
        Optional<AssociationEntity> associationEntityOptional = associationRepo.findById(associationId);
        if (associationEntityOptional.isPresent()) {
            AssociationEntity associationEntity = associationEntityOptional.get();
            String actualSolution = associationEntity.getSolutions().get(column);
            if (Objects.equals(actualSolution, userInput)) {
                throw new CorrectSolutionException();
            } else {
                throw new IncorrectSolutionException();
            }
        } else {
            throw new IncorrectSolutionException();
        }
    }

    @Override
    public boolean checkFinalSolution(Long associationId, String userInput) {
        Optional<AssociationEntity> associationEntityOptional = associationRepo.findById(associationId);
        if (associationEntityOptional.isPresent()) {
            String getFinalSolution = associationEntityOptional.get().getFinalSolutions();
            return Objects.equals(getFinalSolution, userInput);
        } else {
            throw new IncorrectSolutionException();
        }
    }

    public Optional<AssociationDTO> findByRandomNumber(){
        List<AssociationDTO> associationDTOS = getAll();
        if(associationDTOS.isEmpty()) {
            return Optional.empty();
        }
        int randomIndex = (int) (Math.random() * associationDTOS.size());
        return Optional.of(associationDTOS.get(randomIndex));
    }
}