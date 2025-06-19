package com.example.gestiondettes.repository;

import com.example.gestiondettes.entity.Paiement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    Page<Paiement> findByDetteIdAndDetteClientTelephoneContaining(Long detteId, String telephone, Pageable pageable);
}








// import com.example.gestiondettes.entity.Paiement;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// public interface PaiementRepository extends JpaRepository<Paiement, Long> {
//     List<Paiement> findByDetteId(Long detteId);
// }

