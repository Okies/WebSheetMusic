package com.cscs.cscore.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
     * Developer Custom Exception
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException (final BusinessException e) {
        log.warn("handleCustomException : {}", e.getErrorCode());
        final ErrorCode errorCode = e.getErrorCode();

        return handleExceptionInternal(errorCode);
    }

    /*
     * HTTP 405 Exception
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException e) {
        log.warn("handleHttpRequestMethodNotSupportedException : {}", e.getMessage());
        final ErrorCode errorCode = CommonErrorCode.METHOD_NOT_ALLOWED;

        return handleExceptionInternal(errorCode);
    }

    /*
     * HTTP 500 Exception
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(final Exception e) {
        log.warn("handleException: {}", e.getMessage());
        final ErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;

        return handleExceptionInternal(errorCode);
    }

    private ResponseEntity<ErrorResponse> handleExceptionInternal(final ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getStatus())
                .body(makeErrorResponse(errorCode));
    }

    private ErrorResponse makeErrorResponse(final ErrorCode errorCode) {
        return ErrorResponse.builder()
                .status(errorCode.getStatus().value())
                .error(errorCode.getStatus().name())
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }

    private ResponseEntity<ErrorResponse> handleExceptionInternal(final ErrorCode errorCode, final String message) {
        return ResponseEntity.status(errorCode.getStatus())
                .body(makeErrorResponse(errorCode, message));
    }

    private ErrorResponse makeErrorResponse(final ErrorCode errorCode, final String message) {
        return ErrorResponse.builder()
                .status(errorCode.getStatus().value())
                .error(errorCode.getStatus().name())
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }
}
