package com.example.demo.Repo;

import com.example.demo.Enitity.QuizMyNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizMyNumberRepo extends JpaRepository<QuizMyNumberEntity,Long> {
}
