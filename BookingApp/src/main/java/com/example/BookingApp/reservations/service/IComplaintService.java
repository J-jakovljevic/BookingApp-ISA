package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.ComplaintDTO;
import com.example.BookingApp.reservations.model.Complaint;

public interface IComplaintService {
    Complaint createComplaint(ComplaintDTO complaint);
}
