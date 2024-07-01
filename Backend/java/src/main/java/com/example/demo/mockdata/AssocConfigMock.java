package com.example.demo.mockdata;

import com.example.demo.Service.AssociationService;
import com.example.demo.infrastucture.Mapper.AssociationDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class AssocConfigMock implements CommandLineRunner {

    public AssocConfigMock(AssociationService associationService) {
        this.associationService = associationService;
    }

    @Autowired
    private AssociationService associationService;
    @Override
    public void run(String... args) throws Exception {
     associationService.saveAssociation(AssociationDtoMapper.INSTANCE.apply(QuestionsAssociation.getMockAssociation()));
        associationService.saveAssociation(AssociationDtoMapper.INSTANCE.apply(QuestionsAssociation.getMockAssociation2()));

    }
}
