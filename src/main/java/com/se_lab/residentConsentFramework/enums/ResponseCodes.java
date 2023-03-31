package com.se_lab.residentConsentFramework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCodes {

    SUCCESS("INV_200", "Success!", HttpStatus.OK),
    INVALID_EMAIL_ID("INV_001",
            "Invalid email id.", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD_OR_CONFIRM_PASSWORD("INV_004",
            "Password and confirm password cannot be blank.", HttpStatus.BAD_REQUEST),
    PASSWORDS_DO_NOT_MATCH("INV_005",
            "Passwords do not match.", HttpStatus.BAD_REQUEST),
    EMAIL_ID_ALREADY_REGISTERED("INV_006",
            "Given email id is already registered with us. Please use another email id for registration.", HttpStatus.BAD_REQUEST),

    MINISTRY_ALREADY_REGISTERED("RSCM_001","Ministry is already registered",HttpStatus.BAD_REQUEST),
    MINISTRY_NOT_REGISTERED("RSCM_002","Ministry is not registered",HttpStatus.BAD_REQUEST),
    PASSWORD_LENGTH("INV_009",
            "Password must be at-least 8 characters in length.", HttpStatus.BAD_REQUEST),
    INVALID_REQUEST("INV_010", "Invalid request.", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND("INV_011", "No user found corresponding to given email ID/mobile number.",
            HttpStatus.NOT_FOUND),
    INVALID_LOGIN_CREDENTIALS("INV_012", "Please check the login credentials and try again.",
            HttpStatus.BAD_REQUEST),
    INVALID_PAN_NUMBER("INV_013", "Invalid PAN number.", HttpStatus.BAD_REQUEST),
    PAN_NUMBER_ALREADY_REGISTERED("INV_014", "Given PAN number is already registered with us.", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("INV_015", "Access Denied.", HttpStatus.UNAUTHORIZED),
    VALIDATION_ERROR("INV_016", "Validation failed.", HttpStatus.BAD_REQUEST),
    BAD_REQUEST("INV_017", "Validation failed, please try again.", HttpStatus.BAD_REQUEST),
    TRY_AGAIN_LATER("INV_018", "Please try again later.", HttpStatus.BAD_GATEWAY);

    private final String customCode;
    private final String message;
    private final HttpStatus httpStatus;

}