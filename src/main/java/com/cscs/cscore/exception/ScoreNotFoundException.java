package com.cscs.cscore.exception;

import lombok.Getter;

@Getter
public class ScoreNotFoundException extends EntityNotFoundException {

    public ScoreNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
