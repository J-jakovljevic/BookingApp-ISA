package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.repository.ClientRepository;
import com.example.BookingApp.users.service.IClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client registerClient(Client client) {
        return clientRepository.save(client);
    }
}
