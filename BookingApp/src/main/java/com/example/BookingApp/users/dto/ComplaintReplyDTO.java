package com.example.BookingApp.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintReplyDTO {
    private Long id;
    private Long clientId;
    private String description;
    private Long rentingItemId;

}
