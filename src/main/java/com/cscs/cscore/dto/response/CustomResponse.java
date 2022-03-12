package com.cscs.cscore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CustomResponse<T> {

    private int status;
    private String message;
    private T data;

    public CustomResponse(final int status, final String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public static<T> CustomResponse<T> res(final int status, final String message) {
        return res(status, message, null);
    }

    public static<T> CustomResponse<T> res(final int status, final String message, final T t) {
        return CustomResponse.<T>builder()
                .data(t)
                .status(status)
                .message(message)
                .build();
    }
}
