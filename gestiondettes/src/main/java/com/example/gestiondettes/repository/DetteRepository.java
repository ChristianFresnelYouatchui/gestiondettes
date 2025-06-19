package com.example.gestiondettes.repository;

import com.example.gestiondettes.entity.Dette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetteRepository extends JpaRepository<Dette, Long> {
    List<Dette> findByClientId(Long clientId);
}
