package com.cabas.controller;

import com.cabas.controller.dto.AlarmResponseDTO;
import com.cabas.controller.dto.Severity;
import com.cabas.service.AlarmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AlarmController {

    private final AlarmService alarmService;

    @PostMapping("/alarm")
    public AlarmResponseDTO notifyCitizens(
            @RequestParam("area_code") String areaCode,
            @RequestParam("severity") Severity severity) {

        return alarmService.notifyCitizens(areaCode, severity);
    }
}
