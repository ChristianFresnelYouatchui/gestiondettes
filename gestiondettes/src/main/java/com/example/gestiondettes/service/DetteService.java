package com.example.gestiondettes.service;

import com.example.gestiondettes.entity.Client;
import com.example.gestiondettes.entity.Dette;
import com.example.gestiondettes.repository.DetteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetteService {
    
    private final DetteRepository detteRepository;
    private final ClientService clientService;
    
    public Dette createDette(Dette dette, Long clientId) {
        Optional<Client> client = clientService.getClientById(clientId);
        if (client.isPresent()) {
            dette.setClient(client.get());
            if (dette.getDate() == null) {
                dette.setDate(LocalDate.now().toString());
            }
            return detteRepository.save(dette);
        }
        throw new RuntimeException("Client non trouvé");
    }
    
    public List<Dette> getDettesByClient(Long clientId) {
        return detteRepository.findByClientId(clientId);
    }
    
    public Optional<Dette> getDetteById(Long id) {
        return detteRepository.findById(id);
    }
}

