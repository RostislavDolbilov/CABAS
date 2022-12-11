package com.cabas.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class AlarmResponseDTO {

    private Integer notifiedCitizensCount;
    private Integer notificationsSentCount;
    private String areaCode;
}
