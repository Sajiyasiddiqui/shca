package com.hms.User.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hms.User.constant.ErrorInfo;
import com.hms.User.exception.HMSException;

@RestControllerAdvice
public class GlobalExceptionHandler {
          @ExceptionHandler(Exception.class)
          public ResponseEntity<ErrorResponse> exceptionHandler(Exception e)
          {
            ErrorResponse response=new ErrorResponse(ErrorInfo.GENERIC_ERROR.getErrorCode(),ErrorInfo.GENERIC_ERROR.getErrorMessage());
        	  return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
          }
          
          @ExceptionHandler(HMSException.class)
          public ResponseEntity<ErrorResponse> HMSExceptionHandler(HMSException e)
          {
        	  ErrorResponse error= new ErrorResponse(e.getErrorCode(),e.getErrorMessage());
        	  return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
          }
}
