package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.reservations.dto.ComplaintDTO;
import com.example.BookingApp.reservations.model.Complaint;
import com.example.BookingApp.reservations.repository.ComplaintRepository;
import com.example.BookingApp.reservations.service.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService implements IComplaintService {
    private final ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public Complaint createComplaint(ComplaintDTO complaint) {
        return null;
    }
}
