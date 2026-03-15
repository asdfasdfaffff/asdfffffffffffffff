package com.example.gestindeproductosapi.expose.controller;

import com.example.gestindeproductosapi.config.ErrorResponse;
import com.example.gestindeproductosapi.expose.schema.TodoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Validated
@RestController
@Tag(name = "Todo", description = "the Todo API")
public interface TodoApi {

  /**
   * GET /todos/{id} : Get a todo by id.
   */
  @Operation(
      operationId = "getTodo",
      summary = "Get a todo by id",
      tags = { "Todo" },
      responses = {
          @ApiResponse(responseCode = "200", description = "OK", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TodoResponse.class)) }),
          @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }),
          @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
      })
  @RequestMapping(method = RequestMethod.GET, value = "/todos/{id}", produces = { "application/json" })
  Mono<TodoResponse> getTodo(
      @PathVariable String id,
      @RequestParam String status,
      @RequestHeader("Authorization") String authorization
  );

}
