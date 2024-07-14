package com.example.demo.hexagonal_architecture.core.Enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "association")
public class AssociationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "column_a", joinColumns = @JoinColumn(name = "association_id"))
    @Column(name = "value")
    private List<String> columnA = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "column_b", joinColumns = @JoinColumn(name = "association_id"))
    @Column(name = "value")
    private List<String> columnB = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "column_c", joinColumns = @JoinColumn(name = "association_id"))
    @Column(name = "value")
    private List<String> columnC = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "column_d", joinColumns = @JoinColumn(name = "association_id"))
    @Column(name = "value")
    private List<String> columnD = new ArrayList<>();


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "final_solutions", joinColumns = @JoinColumn(name = "association_id"))
    @Column(name = "value")
    private List<String> finalSolutions = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "solutions", joinColumns = @JoinColumn(name = "association_id"))
    @MapKeyColumn(name = "column_name")
    @Column(name = "solution")
    private Map<String, String> solutions = new HashMap<>();


    public void addSolutionToColumn(String columnName, String solution) {
        solutions.put(columnName, solution);
    }


    public void addFinalSolution(String solution) {
        if (finalSolutions == null) {
            finalSolutions = new ArrayList<>();
        }
        finalSolutions.add(solution);
    }
}
