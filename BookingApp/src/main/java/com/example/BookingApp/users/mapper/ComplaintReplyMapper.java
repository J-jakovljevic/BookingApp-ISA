package com.example.BookingApp.users.mapper;
import com.example.BookingApp.users.dto.ComplaintReplyDTO;
import com.example.BookingApp.users.model.ComplaintReply;

public class ComplaintReplyMapper {
    public static ComplaintReplyDTO MapToDTO(ComplaintReply c){
        ComplaintReplyDTO dto = new ComplaintReplyDTO(c.getId(),c.getReciever().getId(),c.getDescription(),c.getRentingItem().getId());
        return dto;
    }

    public static ComplaintReply MapDTOToComplaintReply(ComplaintReplyDTO dto){
        ComplaintReply c = new ComplaintReply();
        c.setDescription(dto.getDescription());
        return c;
    }
}
