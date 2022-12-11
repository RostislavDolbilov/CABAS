package com.cabas.service;

import com.cabas.controller.dto.AlarmResponseDTO;
import com.cabas.controller.dto.Severity;

public interface AlarmService {

    AlarmResponseDTO notifyCitizens(String areaCode, Severity severity);
}
