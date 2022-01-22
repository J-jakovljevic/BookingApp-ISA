package com.example.BookingApp.users.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAccountRequestDTO {
    private Long id;
    private String description;
    private boolean approved;
    private Long clientId;
}