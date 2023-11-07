package org.example.handler;

import org.example.exception.EntityNotFoundException;
import org.example.exception.ErrorDetail;
import org.example.exception.UniqueConstraintException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleEntityNotFoundException(EntityNotFoundException e){
        return new ResponseEntity<>(
                ErrorDetail.builder()
                        .title("Entity not found")
                        .message(e.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .timestamp(Instant.now())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(UniqueConstraintException.class)
    public ResponseEntity<ErrorDetail> handleUniqueConstraintException(UniqueConstraintException e){
        return new ResponseEntity<>(
                ErrorDetail.builder()
                        .title("Unique value already exists")
                        .message(e.getMessage())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .timestamp(Instant.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
