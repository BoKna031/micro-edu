package org.example.handler;

import org.example.exception.EntityNotFoundException;
import org.example.exception.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleEntityNotFoundException(EntityNotFoundException enf){
        return new ResponseEntity<>(
                ErrorDetail.builder()
                        .title("Entity not found")
                        .message(enf.getMessage())
                        .timestamp(Instant.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .build()
                , HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<String> handleRestClientExceptionError(RestClientException e){
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.FAILED_DEPENDENCY
        );
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleRestClientExceptionError(HttpClientErrorException e){
        return new ResponseEntity<>(
                e.getResponseBodyAsString(),
                e.getStatusCode()
        );
    }


}
