package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.email.service.EmailSenderService;
import com.example.BookingApp.users.dto.DeleteAccountRequestDTO;
import com.example.BookingApp.users.mapper.DeleteAccountRequestMapper;
import com.example.BookingApp.users.model.DeleteAccountRequest;
import com.example.BookingApp.users.repository.DeleteAccountRequestRepository;
import com.example.BookingApp.users.service.IClientService;
import com.example.BookingApp.users.service.IDeleteAccountRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteAcountRequestServiceImpl implements IDeleteAccountRequestService {
    private final DeleteAccountRequestRepository deleteAccountRequestRepository;
    private final IClientService clientService;
    private final EmailSenderService emailSenderService;

    @Override
    public DeleteAccountRequest createDeleteAccountRequest(DeleteAccountRequestDTO dto) {
        DeleteAccountRequest deleteAccountRequest = DeleteAccountRequestMapper.MapDTOToDeleteAccountRequest(dto);
        deleteAccountRequest.setClient(clientService.findById(dto.getClientId()));
        emailSenderService.sendAccountDeletionRequest(deleteAccountRequest.getDescription(), deleteAccountRequest.getClient());
        return deleteAccountRequestRepository.save(deleteAccountRequest);
    }
}
