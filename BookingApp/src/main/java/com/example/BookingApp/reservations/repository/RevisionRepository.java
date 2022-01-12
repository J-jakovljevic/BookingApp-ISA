package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RevisionRepository extends JpaRepository<Revision,Long> {
    @Query(value = "SELECT r FROM Revision r WHERE r.rentingItem.id = ?1 and r.approved = true")
    List<Revision> findRevisionsForRentingItem(Long rentingItemId);

    @Query(value = "SELECT r FROM Revision r WHERE r.approved = false")
    List<Revision> getAllUnapprovedRevisions();
}
