package com.example.BookingApp.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CottageOwnerDTO {
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String password;
    private String phoneNumber;
    private String email;
    private String role;
}
