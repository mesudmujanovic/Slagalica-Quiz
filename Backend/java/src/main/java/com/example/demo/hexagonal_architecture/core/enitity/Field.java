package com.example.demo.hexagonal_architecture.core.enitity;

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

    @Enumerated(EnumType.STRING)
    @Column(length = 255)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "association_id")
    private AssociationEntity association;
}