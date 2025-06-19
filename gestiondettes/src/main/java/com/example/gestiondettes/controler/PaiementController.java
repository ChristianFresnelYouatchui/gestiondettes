package com.example.gestiondettes.controler;

import com.example.gestiondettes.entity.Dette;
import com.example.gestiondettes.entity.Paiement;
import com.example.gestiondettes.repository.DetteRepository;
import com.example.gestiondettes.repository.PaiementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementRepository paiementRepository;

    @Autowired
    private DetteRepository detteRepository;

    // ✅ Ajouter un paiement à une dette
    @PostMapping("/dette/{detteId}")
    public ResponseEntity<?> ajouterPaiement(@PathVariable Long detteId, @RequestBody Paiement paiement) {
        Dette dette = detteRepository.findById(detteId).orElse(null);
        if (dette == null) {
            return ResponseEntity.notFound().build();
        }

        paiement.setDette(dette);
        paiementRepository.save(paiement);

        // Recalculer les montants (optionnel si @PreUpdate ne suffit pas)

        dette.getPaiements().add(paiement);
        dette.calculerMontants();
        detteRepository.save(dette);

        return ResponseEntity.ok(paiement);
    }

    // ✅ Liste des paiements filtrés (pagination + téléphone client + detteId)
    @GetMapping
    public Page<Paiement> listerPaiementsParDetteEtTelephone(
            @RequestParam Long detteId,
            @RequestParam(defaultValue = "") String telephone,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return paiementRepository.findByDetteIdAndDetteClientTelephoneContaining(detteId, telephone, pageable);
    }
}


