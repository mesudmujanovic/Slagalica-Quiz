package com.example.demo.hexagonal_architecture.core.enitity.user;

import com.example.demo.hexagonal_architecture.core.enitity.user.UserAuth;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "player")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserAuth user;

    @Column(nullable = false)
    private int totalScore;
}
