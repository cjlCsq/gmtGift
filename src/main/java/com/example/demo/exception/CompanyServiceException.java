package com.example.demo.exception;

import org.springframework.http.HttpStatus;

/**
 * 基础exception类
 */
public abstract class CompanyServiceException extends RuntimeException {

  private final String code;

  protected CompanyServiceException(String code, String message) {
    super(message);
    this.code = code;
  }

  public CompanyServiceException(String code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }


  public String getCode() {
    return code;
  }

  public abstract HttpStatus getStatus();
}
