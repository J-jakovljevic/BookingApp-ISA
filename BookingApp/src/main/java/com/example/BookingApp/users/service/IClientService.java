package com.example.BookingApp.users.service;

import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.model.Client;

import java.util.List;


public interface IClientService {
    Client registerClient(ClientDTO dto);
    List<ClientDTO> getAll();
    Client findById(Long id);
    ClientDTO updateClient(ClientDTO dto);
    Client activateClient(String activationToken);
    void deleteClient(Client client);
}
