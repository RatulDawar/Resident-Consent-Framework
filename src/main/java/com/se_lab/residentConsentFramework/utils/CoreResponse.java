package com.se_lab.residentConsentFramework.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.se_lab.residentConsentFramework.enums.ResponseCodes;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@JsonInclude(value = Include.NON_ABSENT)
public class CoreResponse<T> {

    private String customCode;
    private Object message;
    private T data;

    public static <T> ResponseEntity<CoreResponse<T>> buildSuccessResponseWithData(T data) {
        CoreResponse<T> response = new CoreResponse<>();
        response.setCustomCode(ResponseCodes.SUCCESS.getCustomCode());
        response.setMessage(ResponseCodes.SUCCESS.getMessage());
        response.setData(data);
        return ResponseEntity.status(ResponseCodes.SUCCESS.getHttpStatus()).body(response);
    }

    public static <T> ResponseEntity<CoreResponse<T>> buildSuccessResponse() {
        CoreResponse<T> response = new CoreResponse<>();
        response.setCustomCode(ResponseCodes.SUCCESS.getCustomCode());
        response.setMessage(ResponseCodes.SUCCESS.getMessage());
        return ResponseEntity.status(ResponseCodes.SUCCESS.getHttpStatus()).body(response);
    }

    public static ResponseEntity<Object> buildWithHttpStatusAndMessage(HttpStatus httpStatus,
                                                                       String message) {
        CoreResponse<Object> coreResponse = new CoreResponse<>();
        coreResponse.setCustomCode(String.valueOf(httpStatus.value()));
        coreResponse.setMessage(message);
        return ResponseEntity.status(httpStatus).body(coreResponse);
    }

    public static ResponseEntity<Object> buildWithCustomCodeAndHttpStatusAndMessage(String customCode,
                                                                                    HttpStatus httpStatus, Object message) {
        CoreResponse<Object> coreResponse = new CoreResponse<>();
        coreResponse.setCustomCode(customCode);
        coreResponse.setMessage(message);
        return ResponseEntity.status(httpStatus).body(coreResponse);
    }

}
