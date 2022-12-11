package com.cabas.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CommonErrorResponseDTO {

    private String message;
    private int status;
}
