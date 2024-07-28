package com.example.demo.hexagonal_architecture.core.enitity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "association")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssociationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "association")
    @JsonManagedReference
    private List<Field> fields = new ArrayList<>();

    @CollectionTable(name = "final_solutions", joinColumns = @JoinColumn(name = "association_id"))
    @Column(name = "value")
    private String finalSolutions;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "solutions", joinColumns = @JoinColumn(name = "association_id"))
    @MapKeyColumn(name = "column_name")
    @Column(name = "solution")
    private Map<String, String> solutions = new HashMap<>();
}
