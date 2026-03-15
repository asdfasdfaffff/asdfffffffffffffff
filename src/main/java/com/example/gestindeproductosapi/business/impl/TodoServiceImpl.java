package com.example.gestindeproductosapi.business.impl;

import com.example.gestindeproductosapi.business.TodoService;
import com.example.gestindeproductosapi.business.exception.BusinessErrorCodes;
import com.example.gestindeproductosapi.business.exception.BusinessException;
import com.example.gestindeproductosapi.expose.schema.TodoResponse;
import com.example.gestindeproductosapi.webclient.TodoWebClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class TodoServiceImpl implements TodoService {

  private final TodoWebClient todoWebClient;

  @Override
  public Mono<TodoResponse> getTodo(String id, String status, String authorization) {
    log.info("[TodoService] getTodo id={} status={}", id, status);
    if ("DELETED".equalsIgnoreCase(status)) {
      return Mono.error(BusinessException.of(HttpStatus.UNPROCESSABLE_ENTITY, BusinessErrorCodes.GENERIC_ERROR));
    }
    return todoWebClient.getExample(id, status, authorization)
        .map(res -> TodoResponse.builder()
            .id(id)
            .title(res.getField())
            .status(status)
            .build());
  }

}
