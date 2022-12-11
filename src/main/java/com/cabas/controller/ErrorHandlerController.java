package com.cabas.controller;

import com.cabas.controller.dto.CommonErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<CommonErrorResponseDTO> returnError(ResponseStatusException e) {

        return ResponseEntity
                .status(e.getStatus())
                .body(CommonErrorResponseDTO.builder()
                        .message(e.getReason())
                        .status(e.getRawStatusCode())
                        .build());
    }
}
