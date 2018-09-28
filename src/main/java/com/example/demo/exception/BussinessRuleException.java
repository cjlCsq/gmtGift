package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class BussinessRuleException extends CompanyServiceException {

  protected BussinessRuleException(String code, String message) {
    super(code, message);
  }

  public BussinessRuleException(String code, String message, Throwable cause) {
    super(code, message, cause);
  }

  @Override
  public HttpStatus getStatus() {
    return HttpStatus.BAD_REQUEST;
  }
}
