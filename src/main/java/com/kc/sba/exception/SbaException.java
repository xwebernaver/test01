package com.kc.sba.exception;


import lombok.Getter;

@Getter
public class SbaException extends RuntimeException {
    private SbaErrorCode sbaErrorCode;
    private String detailMessage;

    public SbaException(SbaErrorCode errorCode){
        super(errorCode.getMessage());
        this.sbaErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }

    public SbaException(SbaErrorCode errorCode, String detailMessage){
        super(detailMessage);
        this.sbaErrorCode = errorCode;
        this.detailMessage = detailMessage;
    }

}
