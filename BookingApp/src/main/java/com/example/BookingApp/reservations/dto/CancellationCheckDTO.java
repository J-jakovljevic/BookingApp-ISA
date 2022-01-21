package com.example.BookingApp.reservations.dto;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CancellationCheckDTO {
    private Long clientId;
    private Long rentingItemId;
    private Date startTime;
    private Date endTime;

}
