package com.example.gestindeproductosapi.business;

import com.example.gestindeproductosapi.expose.schema.TodoResponse;
import reactor.core.publisher.Mono;

public interface TodoService {

  Mono<TodoResponse> getTodo(String id, String status, String authorization);

}
