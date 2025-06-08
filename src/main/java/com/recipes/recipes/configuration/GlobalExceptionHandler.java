package com.recipes.recipes.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {
        /*
        * Esta classe tem a intenção de rerranjar o o funcionamento do error handling do spring que, por padrão, não mostra
        * mensagens personalizadas quando um new ResponseStatusException() é gerado
        * */
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(
                new ErrorResponse(ex.getStatusCode().value(), ex.getReason())
        );
    }

    record ErrorResponse(int status, String message) {}
}
