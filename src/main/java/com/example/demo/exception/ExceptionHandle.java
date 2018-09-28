package com.example.demo.exception;

import com.example.demo.result.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandle extends ResponseEntityExceptionHandler {

  private static final String EXCEPTION_MESSAGE = "ExceptionCode = ";

  @ExceptionHandler({Exception.class})
  public ResponseEntity<Object> handleAll(Exception ex) {
    if (ex instanceof CompanyServiceException) {
      if (((CompanyServiceException) ex).getStatus().is5xxServerError()) {
        log.error(EXCEPTION_MESSAGE + HttpStatus.INTERNAL_SERVER_ERROR, ex);
      } else {
        log.warn(EXCEPTION_MESSAGE + ((CompanyServiceException) ex).getStatus(), ex);
      }

      return new ResponseEntity<>(
          new Response<>(((CompanyServiceException) ex).getCode(), ex.getMessage()),
          ((CompanyServiceException) ex).getStatus());
    }
    log.error(EXCEPTION_MESSAGE + HttpStatus.INTERNAL_SERVER_ERROR, ex);
    return new ResponseEntity<>(
        new Response<>("unknown-error", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
