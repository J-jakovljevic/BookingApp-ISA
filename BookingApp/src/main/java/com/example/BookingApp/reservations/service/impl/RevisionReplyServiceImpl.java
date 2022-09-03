package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.reservations.dto.RevisionReplyDTO;
import com.example.BookingApp.reservations.mapper.RevisionReplyMapper;
import com.example.BookingApp.reservations.model.RevisionReply;
import com.example.BookingApp.reservations.repository.RevisionReplyRepository;
import com.example.BookingApp.reservations.service.IRevisionReplyService;
import com.example.BookingApp.reservations.service.IRevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RevisionReplyServiceImpl implements IRevisionReplyService {
    private final IRevisionService revisionService;
    private final RevisionReplyRepository revisionReplyRepository;
    @Override
    public RevisionReply create(RevisionReplyDTO dto) {
        RevisionReply revisionReply = RevisionReplyMapper.MapDTOToRevisionReply(dto);
        revisionReply.setRevision(revisionService.findById(dto.getRevisionId()));
        revisionReply.setApproved(false);
        return revisionReply;
    }

    @Override
    public void approveRevision(Long revisionReplyId) {
        RevisionReply r = revisionReplyRepository.getById(revisionReplyId);
        r.setApproved(true);
        revisionReplyRepository.save(r);
    }

    @Override
    public void deleteRevisionReply(Long revisionReplyId) {
        revisionReplyRepository.delete(revisionReplyRepository.getById(revisionReplyId));
    }

    @Override
    public List<RevisionReply> getAllUnapprovedRevisionReplies() {
        return revisionReplyRepository.getAllUnapprovedRevisionReplies();
    }
}
