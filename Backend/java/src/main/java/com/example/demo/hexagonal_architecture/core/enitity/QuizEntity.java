package com.example.demo.hexagonal_architecture.core.enitity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "quiz")
@Builder
@Data
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player1_id", nullable = false)
    private PlayerEntity player1;

    @ManyToOne
    @JoinColumn(name = "player2_id", nullable = false)
    private PlayerEntity player2;

    @Column(nullable = false)
    private LocalDateTime startTime;
}
