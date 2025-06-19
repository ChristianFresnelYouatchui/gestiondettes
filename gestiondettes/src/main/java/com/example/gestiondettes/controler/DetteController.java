package com.example.gestiondettes.controler;

import com.example.gestiondettes.entity.Client;
import com.example.gestiondettes.entity.Dette;
import com.example.gestiondettes.repository.ClientRepository;
import com.example.gestiondettes.repository.DetteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dettes")
public class DetteController {

    @Autowired
    private DetteRepository detteRepository;

    @Autowired
    private ClientRepository clientRepository;

    // ✅ Ajouter une ou plusieurs dettes à un client
    @PostMapping("/client/{clientId}")
    public ResponseEntity<?> ajouterDettes(@PathVariable Long clientId, @RequestBody List<Dette> dettes) {
        Client client = clientRepository.findById(clientId).orElse(null);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        for (Dette dette : dettes) {
            dette.setClient(client);
        }

        List<Dette> savedDettes = detteRepository.saveAll(dettes);
        return ResponseEntity.ok(savedDettes);
    }

    // ✅ Lister les dettes avec pagination et filtre téléphone
    @GetMapping
    public Page<Dette> getDettesParTelephone(
            @RequestParam(defaultValue = "") String telephone,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return detteRepository.findByClientTelephoneContaining(telephone, pageable);
    }
}


