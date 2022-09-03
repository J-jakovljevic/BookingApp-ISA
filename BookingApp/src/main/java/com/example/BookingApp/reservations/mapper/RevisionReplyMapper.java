package com.example.BookingApp.reservations.mapper;

import com.example.BookingApp.reservations.dto.RevisionReplyDTO;
import com.example.BookingApp.reservations.model.Revision;
import com.example.BookingApp.reservations.model.RevisionReply;

import java.util.ArrayList;
import java.util.List;

public class RevisionReplyMapper {
    public static RevisionReply MapDTOToRevisionReply(RevisionReplyDTO dto){
        RevisionReply r = new RevisionReply();
        r.setOwnerId(dto.getOwnerId());
        r.setDescription(dto.getDescription());
        return r;
    }

    public static RevisionReplyDTO MapToDTO(RevisionReply r){
        RevisionReplyDTO dto = new RevisionReplyDTO(r.getId(),r.getRevision().getId(),r.getOwnerId(),r.getDescription(),r.isApproved());
        return dto;
    }

    public static List<RevisionReplyDTO> MapToListDTO(List<RevisionReply> RevisionReplies){
        List<RevisionReplyDTO> dtos = new ArrayList<RevisionReplyDTO>();
        for(RevisionReply r  : RevisionReplies){
            dtos.add(MapToDTO(r));
        }
        return dtos;
    }

    public static List<RevisionReply> MapDTOSToList(List<RevisionReplyDTO> dtos){
        List<RevisionReply> RevisionReplies = new ArrayList<RevisionReply>();
        for(RevisionReplyDTO dto : dtos){
            RevisionReplies.add(MapDTOToRevisionReply(dto));
        }
        return RevisionReplies;
    }
}
