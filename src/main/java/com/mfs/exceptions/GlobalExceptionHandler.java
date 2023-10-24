package com.mfs.exceptions;

import com.mfs.dtos.ApiErrorResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.io.IOException;
import java.time.Instant;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    protected ResponseEntity<Object> handleBadRequestException(
            RuntimeException exception, WebRequest request) {
        return handleExceptionInternal(exception, BAD_REQUEST, request);
    }

    @ExceptionHandler({IOException.class, NumberFormatException.class, NullPointerException.class, ResponseStatusException.class})
    protected ResponseEntity<Object> handleInternalServerErrorException(
            RuntimeException exception, WebRequest request) {
        return handleExceptionInternal(exception, INTERNAL_SERVER_ERROR, request);
    }

    private ResponseEntity<Object> handleExceptionInternal(
            Exception exception, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(
                exception,
                ApiErrorResponseDTO.builder()
                        .error(exception.getMessage())
                        .status(status)
                        .timestamp(Instant.now())
                        .build(),
                new HttpHeaders(),
                status,
                request);
    }
}