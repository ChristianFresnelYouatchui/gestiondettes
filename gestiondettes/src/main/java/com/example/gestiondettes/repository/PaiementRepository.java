package com.example.gestiondettes.repository;

import com.example.gestiondettes.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByDetteId(Long detteId);
}

