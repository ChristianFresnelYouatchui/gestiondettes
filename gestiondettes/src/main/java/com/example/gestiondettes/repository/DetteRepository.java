package com.example.gestiondettes.repository;

import com.example.gestiondettes.entity.Dette;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DetteRepository extends JpaRepository<Dette, Long> {
    Page<Dette> findByClientTelephoneContaining(String telephone, Pageable pageable);
    List<Dette> findByClientId(Long clientId);
}




// import com.example.gestiondettes.entity.Dette;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// public interface DetteRepository extends JpaRepository<Dette, Long> {
//     List<Dette> findByClientId(Long clientId);
// }
