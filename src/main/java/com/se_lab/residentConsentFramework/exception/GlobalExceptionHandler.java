package com.se_lab.residentConsentFramework.exception;

import com.se_lab.residentConsentFramework.utils.CoreResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({RSCMException.class})
    public ResponseEntity<Object> handleApplicationException(Exception ex) {
        HttpStatus httpStatus = ((RSCMException) ex).getHttpStatusCode();
        String customCode = ((RSCMException) ex).getCustomCode();
        String errorMsg = ((RSCMException) ex).getInternalMessage();
        return CoreResponse.buildWithCustomCodeAndHttpStatusAndMessage(customCode, httpStatus,
                errorMsg);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleCustomException(ConstraintViolationException ex) {
        return CoreResponse.buildWithCustomCodeAndHttpStatusAndMessage("INV_400", HttpStatus.BAD_REQUEST,
                ex.getConstraintName());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleCustomException(AccessDeniedException ex) {
        return CoreResponse.buildWithCustomCodeAndHttpStatusAndMessage("INV_401", HttpStatus.UNAUTHORIZED,
                "Access Denied.");
    }

    @Getter
    @Setter
    @Builder
    public static class CustomError {
        private String field;
        private String message;
        private Object rejectedValue;
    }

}
