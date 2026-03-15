package com.example.gestindeproductosapi.config;

import com.example.gestindeproductosapi.business.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RestControllerAdvice
@SuppressWarnings("unused")
public class GlobalExceptionHandler {

  private String resolveTrace(ServerWebExchange exchange) {
    Object t = exchange.getAttributes().get(TraceWebFilter.MDC_KEY);
    return t != null ? t.toString() : UUID.randomUUID().toString();
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponse> handleBusiness(BusinessException ex, ServerWebExchange exchange) {
    String trace = resolveTrace(exchange);
    String path = exchange.getRequest().getPath().value();
    log.warn("[GlobalExceptionHandler] trace={} code={} path={} error={}", trace, ex.getCode(), path, ex.getMessage());
    return ResponseEntity.status(ex.getStatus()).body(ErrorResponse.builder()
        .trace(trace)
        .timestamp(LocalDateTime.now())
        .status(ex.getStatus().value())
        .code(ex.getCode())
        .message(ex.getDescription())
        .path(path)
        .detail(ex.getDetail())
        .build());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception ex, ServerWebExchange exchange) {
    String trace = resolveTrace(exchange);
    String path = exchange.getRequest().getPath().value();
    log.error("[GlobalExceptionHandler] trace={} path={} error={}", trace, path, ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder()
        .trace(trace)
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .message("Ocurrió un error inesperado, por favor intente más tarde")
        .path(path)
        .detail(ex.getMessage())
        .build());
  }

}
