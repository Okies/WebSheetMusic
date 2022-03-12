package com.cscs.cscore.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {

    private final LocalDateTime localDateTime = LocalDateTime.now();
    private final int status;
    private final String error;
    private final String code;
    private final String message;

    public ErrorResponse(ErrorCode ErrorCode) {
        this.status = ErrorCode.getStatus().value();
        this.error = ErrorCode.getStatus().name();
        this.code = ErrorCode.name();
        this.message = ErrorCode.getMessage();
    }
}
