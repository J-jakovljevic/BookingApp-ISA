package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.RevisionReplyDTO;
import com.example.BookingApp.reservations.model.RevisionReply;

import java.util.List;

public interface IRevisionReplyService {
    RevisionReply create(RevisionReplyDTO dto);

    void approveRevision(Long revisionReplyId);

    void deleteRevisionReply(Long revisionReplyId);

    List<RevisionReply> getAllUnapprovedRevisionReplies();
}
