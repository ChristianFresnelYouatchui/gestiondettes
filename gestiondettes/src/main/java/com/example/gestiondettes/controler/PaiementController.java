package com.example.gestiondettes.controler;

import com.example.gestiondettes.entity.Dette;
import com.example.gestiondettes.entity.Paiement;
import com.example.gestiondettes.repository.DetteRepository;
import com.example.gestiondettes.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementRepository paiementRepository;

    @Autowired
    private DetteRepository detteRepository;

    // Ajouter un paiement à une dette
    @PostMapping("/dette/{detteId}")
    public ResponseEntity<Paiement> ajouterPaiement(@PathVariable Long detteId, @RequestBody Paiement paiement) {
        Dette dette = detteRepository.findById(detteId).orElse(null);
        if (dette == null) return ResponseEntity.notFound().build();

        paiement.setDette(dette);
        return ResponseEntity.ok(paiementRepository.save(paiement));
    }

    // Lister les paiements d'une dette
    @GetMapping("/dette/{detteId}")
    public ResponseEntity<List<Paiement>> getPaiementsByDette(@PathVariable Long detteId) {
        return ResponseEntity.ok(paiementRepository.findByDetteId(detteId));
    }
}