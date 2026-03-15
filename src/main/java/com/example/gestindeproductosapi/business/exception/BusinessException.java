package com.example.gestindeproductosapi.business.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {

  private final HttpStatus status;
  private final String code;
  private final String description;
  private final String detail;

  private BusinessException(HttpStatus status, BusinessErrorCodes errorCode, String detail) {
    super(errorCode.getDescription());
    this.status = status;
    this.code = errorCode.getCode();
    this.description = errorCode.getDescription();
    this.detail = detail;
  }

  public static BusinessException of(HttpStatus status, BusinessErrorCodes errorCode) {
    return new BusinessException(status != null ? status : HttpStatus.INTERNAL_SERVER_ERROR, errorCode, null);
  }

  public static BusinessException of(HttpStatus status, BusinessErrorCodes errorCode, String detail) {
    return new BusinessException(status != null ? status : HttpStatus.INTERNAL_SERVER_ERROR, errorCode, detail);
  }

  public static BusinessException of(BusinessErrorCodes errorCode) {
    return new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, errorCode, null);
  }

}
