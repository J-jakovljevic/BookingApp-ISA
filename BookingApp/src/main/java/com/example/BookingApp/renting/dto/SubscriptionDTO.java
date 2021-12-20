package com.example.BookingApp.renting.dto;

import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.users.dto.UserDTO;
import com.example.BookingApp.users.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDTO {
    private Long id;
    private Long userId;
    private Long rentingItemId;

}
