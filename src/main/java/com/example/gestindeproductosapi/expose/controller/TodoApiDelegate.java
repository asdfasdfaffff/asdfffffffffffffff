package com.example.gestindeproductosapi.expose.controller;

import com.example.gestindeproductosapi.expose.schema.TodoResponse;
import reactor.core.publisher.Mono;

public interface TodoApiDelegate {

  Mono<TodoResponse> getTodo(String id, String status, String authorization);

}
