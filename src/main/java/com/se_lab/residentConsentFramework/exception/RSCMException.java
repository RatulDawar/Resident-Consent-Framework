package com.se_lab.residentConsentFramework.exception;

import com.se_lab.residentConsentFramework.enums.ResponseCodes;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class RSCMException extends RuntimeException{
    private String internalMessage;
    private HttpStatus httpStatusCode;
    private String customCode;

    public RSCMException(ResponseCodes errorCode) {
        super(errorCode.getMessage());
        this.internalMessage = errorCode.getMessage();
        this.httpStatusCode = errorCode.getHttpStatus();
        this.customCode = errorCode.getCustomCode();
    }

    public RSCMException(ResponseCodes errorCode, String message) {
        super(errorCode.getMessage());
        this.internalMessage = message;
        this.httpStatusCode = errorCode.getHttpStatus();
        this.customCode = errorCode.getCustomCode();
    }

    public RSCMException(ResponseCodes errorCode, String message, HttpStatus httpStatus) {
        super(errorCode.getMessage());
        this.internalMessage = message;
        this.httpStatusCode = httpStatus;
        this.customCode = errorCode.getCustomCode();
    }
}
