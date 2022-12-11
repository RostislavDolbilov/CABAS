package com.cabas.service.impl;

import com.cabas.controller.dto.AlarmResponseDTO;
import com.cabas.controller.dto.Severity;
import com.cabas.converter.CitizenDtoConverter;
import com.cabas.entity.Area;
import com.cabas.entity.Citizen;
import com.cabas.notification.dto.CitizenNotificationRequestDTO;
import com.cabas.notification.service.NotificationService;
import com.cabas.repository.AreaRepository;
import com.cabas.repository.CitizenRepository;
import com.cabas.service.AlarmService;
import com.cabas.templates.NotificationMessageTemplate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AlarmServiceImpl implements AlarmService {

    private final AreaRepository areaRepository;
    private final CitizenRepository citizenRepository;
    private final NotificationService notificationService;
    private final NotificationMessageTemplate notificationMessageTemplate;


    @Override
    public AlarmResponseDTO notifyCitizens(String areaCode, Severity severity) {

        Area area = areaRepository.findByAreaCode(areaCode)
                .orElseThrow(() -> {
                    String message = String.format("Area with such code [%s] does not exist", areaCode);
                    log.error(message);

                    return new ResponseStatusException(HttpStatus.NOT_FOUND, message);
                });

        List<Citizen> citizens = citizenRepository.findCitizensByAreaCode(area);
        if (citizens.isEmpty()) {
            String message = String.format("No citizens found in area [%s]", areaCode);
            log.error(message);

            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, message);
        }

        List<CitizenNotificationRequestDTO> citizensDto = CitizenDtoConverter.convertList(citizens, true);

        notificationService.sendRequest(
                citizensDto,
                notificationMessageTemplate.getMessageTemplate(severity)
        );

        log.info("Notified {} citizens in Country Area {} about COVID severity {}",
                citizens.size(),
                areaCode,
                severity
        );

        return AlarmResponseDTO.builder()
                .areaCode(areaCode)
                .notifiedCitizensCount(citizens.size())
                .notificationsSentCount(citizensDto.size())
                .build();
    }
}
