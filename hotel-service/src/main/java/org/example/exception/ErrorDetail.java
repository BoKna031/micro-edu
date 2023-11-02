package org.example.exception;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ErrorDetail {
    private String title;
    private int status;
    private String message;
    private Instant timestamp;
}
