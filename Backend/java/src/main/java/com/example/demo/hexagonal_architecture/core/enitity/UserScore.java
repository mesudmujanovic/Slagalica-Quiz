package com.example.demo.hexagonal_architecture.core.enitity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserAuth user;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private int totalScore;
}
