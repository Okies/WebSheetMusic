package com.cscs.cscore.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    String name();
    HttpStatus getStatus();
    String getMessage();

}
