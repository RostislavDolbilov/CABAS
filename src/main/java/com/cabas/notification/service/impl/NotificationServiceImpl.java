package com.cabas.notification.service.impl;

import com.cabas.configuration.CabasConfigurationProperties;
import com.cabas.notification.dto.CitizenNotificationRequestDTO;
import com.cabas.notification.dto.NotificationRequestDTO;
import com.cabas.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final RestTemplate restTemplate;
    private final CabasConfigurationProperties configurationProperties;

    @Override
    public void sendRequest(List<CitizenNotificationRequestDTO> citizens, String message) {

        HttpEntity<NotificationRequestDTO> requestEntity = new HttpEntity<>(
                NotificationRequestDTO.builder()
                        .citizens(citizens)
                        .message(message)
                        .build()
        );

        try {
            restTemplate.exchange(
                    String.format("%s/api/alarm", configurationProperties.getNotificationBaseUrl()),
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

        } catch (RestClientResponseException e) {
            log.error("Error on sending request to Notification Service:", e);
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Upstream service is currently unavailable");
        }

    }
}
