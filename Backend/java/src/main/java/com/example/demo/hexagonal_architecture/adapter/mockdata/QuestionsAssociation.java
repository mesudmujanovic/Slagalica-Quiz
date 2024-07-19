package com.example.demo.hexagonal_architecture.adapter.mockdata;

import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class QuestionsAssociation {
    private static final String FILE_NAME = "mock_data.json";
    public static List<AssociationEntity> getMockAssociation() {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<InputStream> inputStreamOpt = Optional.ofNullable(QuestionsAssociation.class.getClassLoader().getResourceAsStream(FILE_NAME));
        InputStream inputStream = inputStreamOpt.orElseThrow(() -> new IllegalArgumentException("Cannot find resource file: " + FILE_NAME));
        try {
            return Arrays.asList(objectMapper.readValue(inputStream, AssociationEntity[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}