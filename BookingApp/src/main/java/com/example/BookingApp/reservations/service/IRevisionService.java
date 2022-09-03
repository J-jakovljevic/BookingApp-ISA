package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.RevisionDTO;
import com.example.BookingApp.reservations.model.Revision;

import java.util.List;

public interface IRevisionService {
    double countAverageGradeForRentingItem(Long rentingItemId);
    Revision create(RevisionDTO dto);
    void approveRevision(Long revisionId);
    void deleteRevision(Long revisionId);
    List<Revision> getAllUnapprovedRevisions();
    Revision findById(Long revisionId);

    Revision getRevisionForReservation(Long reservationId);
}
