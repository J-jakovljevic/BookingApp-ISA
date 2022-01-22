package com.example.BookingApp.users.service;

import com.example.BookingApp.users.dto.DeleteAccountRequestDTO;
import com.example.BookingApp.users.dto.DeleteAccountRequestReplyDTO;
import com.example.BookingApp.users.model.DeleteAccountRequest;

import java.util.List;

public interface IDeleteAccountRequestService {
    DeleteAccountRequest createDeleteAccountRequest(DeleteAccountRequestDTO dto);
    List<DeleteAccountRequest> getAll();
    DeleteAccountRequest approveRequest(DeleteAccountRequestReplyDTO dto);
    DeleteAccountRequest denyRequest(DeleteAccountRequestReplyDTO dto);
}
