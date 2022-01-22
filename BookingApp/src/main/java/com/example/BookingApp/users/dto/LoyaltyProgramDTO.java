package com.example.BookingApp.users.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoyaltyProgramDTO {
    private Long id;
    private double pointsPerReservation;
    private double silverMemberThreshold;
    private double goldenMemberThreshold;
}
