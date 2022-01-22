package com.example.BookingApp.renting.repository;
import com.example.BookingApp.renting.model.FishingInstructorClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishingInstructorClassRepository extends JpaRepository<FishingInstructorClass,Long> {
}
