package com.cabas.converter;

import com.cabas.entity.Citizen;
import com.cabas.notification.dto.CitizenNotificationRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class CitizenDtoConverter {

    public static CitizenNotificationRequestDTO convert(Citizen citizen) {
        return CitizenNotificationRequestDTO.builder()
                .firstName(citizen.getFirstName())
                .lastName(citizen.getLastName())
                .phoneNumber(citizen.getPhone())
                .build();
    }

    public static List<CitizenNotificationRequestDTO> convertList(List<Citizen> citizens, boolean includeGuardians) {
        List<CitizenNotificationRequestDTO> responseList = new ArrayList<>();
        citizens
                .forEach(citizen -> {
                    responseList.add(convert(citizen));

                    if (includeGuardians && citizen.getGuardian() != null) {
                        responseList.add(convert(citizen.getGuardian()));
                    }
                });

        return responseList;
    }
}
