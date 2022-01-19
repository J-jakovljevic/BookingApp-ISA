package com.example.BookingApp.users.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAccountRequestReplyDTO {
    private Long deleteAccountRequestId;
    private String description;
    private Long clientId;
}
