package com.cabas.notification.service;

import com.cabas.notification.dto.CitizenNotificationRequestDTO;

import java.util.List;

public interface NotificationService {

    void sendRequest(List<CitizenNotificationRequestDTO> citizens, String message);
}
