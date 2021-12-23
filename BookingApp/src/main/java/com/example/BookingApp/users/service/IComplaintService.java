package com.example.BookingApp.users.service;

import com.example.BookingApp.users.dto.ComplaintDTO;
import com.example.BookingApp.users.dto.ComplaintReplyDTO;
import com.example.BookingApp.users.model.Complaint;
import com.example.BookingApp.users.model.ComplaintReply;

public interface IComplaintService {
    Complaint createComplaint(ComplaintDTO dto);
    ComplaintReply createComplaintReply(ComplaintReplyDTO dto);
}
