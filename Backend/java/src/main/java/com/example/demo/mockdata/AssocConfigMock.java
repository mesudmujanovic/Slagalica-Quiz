package com.example.demo.mockdata;

import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.port.out.in.AssociationService;
import com.example.demo.hexagonal_architecture.adapter.mapperDto.AssociationDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AssocConfigMock implements CommandLineRunner {
    private final AssociationService associationService;
    private final AssociationDtoMapper associationDtoMapper;

    @Override
    public void run(String... args) throws Exception {
        Optional<List<AssociationEntity>> associationsOptional = Optional.ofNullable(QuestionsAssociation.getMockAssociation());
        associationsOptional.ifPresentOrElse(
                associations -> associations.forEach(entity -> associationService.saveAssociation(associationDtoMapper.apply(entity))),
                () -> System.out.println("No associations loaded from mock data.")
        );
    }
}