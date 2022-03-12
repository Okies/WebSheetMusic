package com.cscs.cscore.exception;

import lombok.Getter;

@Getter
public class PostNotFoundException extends EntityNotFoundException{

    public PostNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
