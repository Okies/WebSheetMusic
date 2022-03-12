package com.cscs.cscore.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends BusinessException{

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
