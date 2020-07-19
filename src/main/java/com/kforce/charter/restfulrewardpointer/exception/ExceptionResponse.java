package com.kforce.charter.restfulrewardpointer.exception;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ExceptionResponse extends RuntimeException {
    private final LocalDateTime timeStamp;
    private final String message;
}
