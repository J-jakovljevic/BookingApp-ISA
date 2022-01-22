package com.example.BookingApp.users.dto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDTO {
    private Long id;
    private Long clientId;
    private Long rentingItemId;
    private String description;

}
