package com.cabas.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CitizenNotificationRequestDTO {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String message;
}
