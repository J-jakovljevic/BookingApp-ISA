package com.example.BookingApp.reservations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RevisionReplyDTO {
    private Long id;
    private Long revisionId;
    private Long ownerId;
    private String description;
    private boolean approved;
}
