package com.example.demo.hexagonal_architecture.core.service;

import com.example.demo.hexagonal_architecture.core.port.out.in.FieldRepository;
import com.example.demo.hexagonal_architecture.core.enitity.Field;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FieldService {

    @Autowired
    private FieldRepository fieldRepository;


    public Optional<Field> findFieldByPositionOptional(Position position) {
        return fieldRepository.findByPosition(position);
    }
}
