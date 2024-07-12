package com.example.demo.mockdata;

import com.example.demo.Enitity.AssociationEntity;
import com.example.demo.Service.AssociationService;
import com.example.demo.infrastucture.Mapper.AssociationDtoMapper;
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