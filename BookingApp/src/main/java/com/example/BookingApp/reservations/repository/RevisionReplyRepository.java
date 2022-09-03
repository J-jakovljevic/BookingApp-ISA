package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.RevisionReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevisionReplyRepository  extends JpaRepository<RevisionReply,Long> {
    @Query(value = "SELECT r FROM RevisionReply r WHERE r.approved = false")
    List<RevisionReply> getAllUnapprovedRevisionReplies();
}
