package com.example.gestiondettes.repository;


import com.example.gestiondettes.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
