package com.example.gestindeproductosapi.webclient;

import com.example.gestindeproductosapi.webclient.reqres.TodoWcRequest;
import com.example.gestindeproductosapi.webclient.reqres.TodoWcResponse;
import reactor.core.publisher.Mono;

@SuppressWarnings("unused")
public interface TodoWebClient {

  Mono<TodoWcResponse> getExample(String id, String filter, String authorization);

  Mono<TodoWcResponse> postExample(TodoWcRequest request, String authorization);

  Mono<TodoWcResponse> putExample(String id, TodoWcRequest request, String authorization);

  Mono<TodoWcResponse> patchExample(String id, TodoWcRequest request, String authorization);

  Mono<Void> deleteExample(String id, String authorization);

}
