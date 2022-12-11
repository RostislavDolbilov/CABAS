package com.cabas.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class NotificationRequestDTO {
    private List<CitizenNotificationRequestDTO> citizens;
    private String message;
}
