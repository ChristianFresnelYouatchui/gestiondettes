package com.example.gestiondettes.controler;

import com.example.gestiondettes.dto.HistoriqueDTO;
import com.example.gestiondettes.entity.Client;
import com.example.gestiondettes.entity.Dette;
import com.example.gestiondettes.entity.Paiement;
import com.example.gestiondettes.repository.ClientRepository;
import com.example.gestiondettes.repository.DetteRepository;
import com.example.gestiondettes.repository.PaiementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/historique")
public class HistoriqueController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DetteRepository detteRepository;

    @Autowired
    private PaiementRepository paiementRepository;

    @GetMapping("/client")
    public ResponseEntity<Page<HistoriqueDTO>> getHistoriqueParClient(
            @RequestParam String telephone,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Client client = clientRepository.findByTelephone(telephone);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        List<Dette> dettes = detteRepository.findAll().stream()
                .filter(d -> d.getClient().getId().equals(client.getId()))
                .collect(Collectors.toList());

        List<Paiement> paiements = paiementRepository.findAll().stream()
                .filter(p -> p.getDette().getClient().getId().equals(client.getId()))
                .collect(Collectors.toList());

        List<HistoriqueDTO> historique = new ArrayList<>();

        for (Dette d : dettes) {
            historique.add(new HistoriqueDTO("DETTE", d.getDate(), d.getMontantDette(), d.getId()));
        }

        for (Paiement p : paiements) {
            historique.add(new HistoriqueDTO("PAIEMENT", p.getDate(), p.getMontant(), p.getId()));
        }

        historique.sort((a, b) -> b.getDate().compareTo(a.getDate()));

        int start = Math.min(page * size, historique.size());
        int end = Math.min(start + size, historique.size());
        List<HistoriqueDTO> pageContent = historique.subList(start, end);

        return ResponseEntity.ok(new PageImpl<>(pageContent, PageRequest.of(page, size), historique.size()));
    }
}
