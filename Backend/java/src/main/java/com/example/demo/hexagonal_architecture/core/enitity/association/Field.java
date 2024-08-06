package com.example.demo.hexagonal_architecture.core.enitity.association;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "field")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String text;

    private String columnPosition;

    @Enumerated(EnumType.STRING)
    @Column(length = 255)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "association_id")
    @JsonBackReference
    private AssociationEntity association;
}