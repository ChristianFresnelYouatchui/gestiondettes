// package com.example.gestiondettes.service.impl;

// import com.example.gestiondettes.service.ClientService;
// import com.example.gestiondettes.entity.Client;
// import com.example.gestiondettes.repository.ClientRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class ClientServiceImpl implements ClientService {
//     @Autowired
//     private ClientRepository clientRepo;

//     @Override
//     public Client ajouterClient(Client client) {
//         return clientRepo.save(client);
//     }

//     @Override
//     public List<Client> listerClients() {
//         return clientRepo.findAll();
//     }
// }
