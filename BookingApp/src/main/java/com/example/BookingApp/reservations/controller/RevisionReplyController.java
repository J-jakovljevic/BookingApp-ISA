package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.BoatOwnerAuthorization;
import com.example.BookingApp.autorizationAnnotations.CottageOwnerAuthorization;
import com.example.BookingApp.autorizationAnnotations.SystemAdminAuthorization;
import com.example.BookingApp.reservations.dto.RevisionDTO;
import com.example.BookingApp.reservations.dto.RevisionReplyDTO;
import com.example.BookingApp.reservations.mapper.RevisionMapper;
import com.example.BookingApp.reservations.mapper.RevisionReplyMapper;
import com.example.BookingApp.reservations.model.Revision;
import com.example.BookingApp.reservations.model.RevisionReply;
import com.example.BookingApp.reservations.service.IRevisionReplyService;
import com.example.BookingApp.reservations.service.IRevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/revisionReplies")
@RequiredArgsConstructor
public class RevisionReplyController {
    private final IRevisionReplyService revisionReplyService;

    @CottageOwnerAuthorization
    @BoatOwnerAuthorization
    @PostMapping(value = "/create", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public RevisionReplyDTO create(@RequestBody RevisionReplyDTO dto) throws ParseException {
        RevisionReply revisionReply;
        try {
            revisionReply = revisionReplyService.create(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return RevisionReplyMapper.MapToDTO(revisionReply);
    }

    @SystemAdminAuthorization
    @PostMapping(value = "/approveRevisionReply", consumes =MediaType.APPLICATION_JSON_VALUE)
    public boolean approveRevisionReply(@RequestBody Long revisionReplyId) throws ParseException {
        try {
            revisionReplyService.approveRevision(revisionReplyId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @SystemAdminAuthorization
    @PostMapping(value = "/denyRevisionReply", consumes =MediaType.APPLICATION_JSON_VALUE)
    public boolean denyRevisionReply(@RequestBody Long revisionReplyId) throws ParseException {
        try {
            revisionReplyService.deleteRevisionReply(revisionReplyId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @SystemAdminAuthorization
    @GetMapping(value = "/getAllUnapprovedRevisionReplies", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<RevisionReplyDTO> getAllUnapprovedRevisionReplies() throws ParseException {
        return RevisionReplyMapper.MapToListDTO(revisionReplyService.getAllUnapprovedRevisionReplies());
    }
}
