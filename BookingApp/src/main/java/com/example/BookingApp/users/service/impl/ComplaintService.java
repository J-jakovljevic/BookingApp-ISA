package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.email.service.EmailSenderService;
import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.renting.service.impl.RentingItemService;
import com.example.BookingApp.users.dto.ComplaintDTO;
import com.example.BookingApp.users.dto.ComplaintReplyDTO;
import com.example.BookingApp.users.mapper.ComplaintMapper;
import com.example.BookingApp.users.mapper.ComplaintReplyMapper;
import com.example.BookingApp.users.model.Complaint;
import com.example.BookingApp.users.model.ComplaintReply;
import com.example.BookingApp.users.repository.ComplaintReplyRepository;
import com.example.BookingApp.users.repository.ComplaintRepository;
import com.example.BookingApp.users.service.IClientService;
import com.example.BookingApp.users.service.IComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComplaintService implements IComplaintService {
    private final ComplaintRepository complaintRepository;
    private final IRentingItemService rentingItemService;
    private final IClientService clientService;
    private final EmailSenderService emailSenderService;
    private final ComplaintReplyRepository complaintReplyRepository;


    @Override
    public Complaint createComplaint(ComplaintDTO dto) {
        Complaint c = ComplaintMapper.MapDTOToComplaint(dto);
        c.setSender(clientService.findById(dto.getClientId()));
        c.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        emailSenderService.sendComplaintEmail(dto.getDescription(),c.getSender(),c.getRentingItem());
        return complaintRepository.save(c);
    }

    @Override
    public ComplaintReply createComplaintReply(ComplaintReplyDTO dto) {
        ComplaintReply c = ComplaintReplyMapper.MapDTOToComplaintReply(dto);
        c.setReciever(clientService.findById(dto.getClientId()));
        c.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        emailSenderService.sendComplaintReplyEmail(dto.getDescription(),c.getReciever(),c.getRentingItem());
        return complaintReplyRepository.save(c);
    }
}
