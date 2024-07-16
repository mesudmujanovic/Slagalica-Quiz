package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.Enitity.UserInfoContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoContactRepository extends JpaRepository<UserInfoContact, Long> {
}
