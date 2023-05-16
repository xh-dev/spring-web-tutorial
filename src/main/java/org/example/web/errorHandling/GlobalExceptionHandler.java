package org.example.web.errorHandling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.http.HttpResponse;
import java.util.Optional;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorDto{
        private String name;
        private String message;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        return ResponseEntity.of(Optional.of(ErrorDto.builder().name(e.getClass().getName()).message(e.getMessage()).build()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.of(Optional.of(ErrorDto.builder().name(e.getClass().getName()).message(e.getMessage()).build()));
    }
}
