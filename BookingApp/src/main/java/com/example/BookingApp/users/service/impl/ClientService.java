package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.mapper.ClientMapper;
import com.example.BookingApp.users.model.Authority;
import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.repository.ClientRepository;
import com.example.BookingApp.users.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;

    @Autowired
    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder, AuthorityService authorityService) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
    }

    @Override
    public Client registerClient(ClientDTO dto) {
      //  Address a = AddressMapper.MapDTOToAddress(dto.getAddress());
       // addressRepository.save(a);
        Client c = ClientMapper.MapDTOToClient(dto);
        ///c.setAddress(a);
        c.setPassword(passwordEncoder.encode(dto.getPassword()));
        c.setEnabled(true);
        List<Authority> auth = authorityService.findByName("ROLE_CLIENT");
        c.setAuthorities(auth);
        clientRepository.save(c);
        return c;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clients = clientRepository.findAll();
        return ClientMapper.MapToListDTOS(clients);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public ClientDTO updateClient(ClientDTO dto) {
        Client c = clientRepository.getById(dto.getId());
        c.setSurname(dto.getSurname());
        c.setName(dto.getName());
        c.setPhoneNumber(dto.getPhoneNumber());
       /* Address a = addressRepository.getById(dto.getAddress().getId());
        a.setState(dto.getAddress().getState());
        a.setCity(dto.getAddress().getCity());
        a.setStreet(dto.getAddress().getStreet());
        a.setLongitude(dto.getAddress().getLongitude());
        a.setLatitude(dto.getAddress().getLatitude());
        addressRepository.save(a);*/
        c.setAddress(dto.getAddress());
        clientRepository.save(c);
        return ClientMapper.MapToDTO(c);
    }
}
