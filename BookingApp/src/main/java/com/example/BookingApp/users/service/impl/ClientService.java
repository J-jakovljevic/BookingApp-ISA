package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.mapper.AddressMapper;
import com.example.BookingApp.users.mapper.ClientMapper;
import com.example.BookingApp.users.model.Address;
import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.repository.AddressRepository;
import com.example.BookingApp.users.repository.ClientRepository;
import com.example.BookingApp.users.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, AddressRepository addressRepository) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Client registerClient(ClientDTO dto) {
        Address a = AddressMapper.MapDTOToAddress(dto.getAddress());
        addressRepository.save(a);
        Client c = ClientMapper.MapDTOToClient(dto);
        c.setAddress(a);
        clientRepository.save(c);
        return c;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clients = clientRepository.findAll();
        return ClientMapper.MapToListDTOS(clients);
    }
}
