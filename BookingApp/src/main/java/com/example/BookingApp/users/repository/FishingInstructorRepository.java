package com.example.BookingApp.users.repository;

import com.example.BookingApp.users.model.FishingInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishingInstructorRepository extends JpaRepository<FishingInstructor,Long> {
}
