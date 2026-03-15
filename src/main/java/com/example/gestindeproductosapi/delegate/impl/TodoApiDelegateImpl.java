package com.example.gestindeproductosapi.delegate.impl;

import com.example.gestindeproductosapi.expose.controller.TodoApiDelegate;
import com.example.gestindeproductosapi.business.TodoService;
import com.example.gestindeproductosapi.expose.schema.TodoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@SuppressWarnings("all")
@RequiredArgsConstructor
public class TodoApiDelegateImpl implements TodoApiDelegate {

  private final TodoService service;

  @Override
  public Mono<TodoResponse> getTodo(String id, String status, String authorization) {
    return service.getTodo(id, status, authorization);
  }

}
