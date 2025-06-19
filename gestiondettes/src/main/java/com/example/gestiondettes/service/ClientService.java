package com.example.gestiondettes.service;

// import com.example.gestiondettes.entity.Client;
// import java.util.List;

// public interface ClientService {
//     Client ajouterClient(Client client);
//     List<Client> listerClients();
// }


import com.example.gestiondettes.entity.Client;
import com.example.gestiondettes.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository clientRepository;
    
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
    
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }
    
    public Optional<Client> getClientByTelephone(String telephone) {
        return Optional.ofNullable(clientRepository.findByTelephone(telephone));
    }
}
