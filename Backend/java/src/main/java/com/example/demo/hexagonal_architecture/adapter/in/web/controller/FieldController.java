package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.core.enitity.Field;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import com.example.demo.hexagonal_architecture.core.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fields")
public class FieldController {

    @Autowired
    private FieldService fieldService;
    @GetMapping("/search")
    public ResponseEntity<Field> findFieldByPositionOptional(@RequestParam Position position) {
        return fieldService.findFieldByPositionOptional(position)
                .map(field -> ResponseEntity.ok(field))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}