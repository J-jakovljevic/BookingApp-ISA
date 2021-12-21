package com.example.BookingApp.users.service;

import com.example.BookingApp.users.dto.DeleteAccountRequestDTO;
import com.example.BookingApp.users.model.DeleteAccountRequest;

public interface IDeleteAccountRequestService {
    DeleteAccountRequest createDeleteAccountRequest(DeleteAccountRequestDTO dto);
}
