package com.example.gestindeproductosapi.expose.controller;

import com.example.gestindeproductosapi.expose.schema.TodoResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Getter
@RestController
@SuppressWarnings("unused")
public class TodoApiController implements TodoApi {

  private final TodoApiDelegate delegate;

  public TodoApiController(@Autowired(required = false) TodoApiDelegate delegate) {
    this.delegate = delegate;
  }

  @Override
  public Mono<TodoResponse> getTodo(String id, String status, String authorization) {
    return getDelegate().getTodo(id, status, authorization);
  }

}
