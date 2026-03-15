package com.example.gestindeproductosapi.expose.controller;

import com.example.gestindeproductosapi.expose.schema.CreateProductRequest;
import com.example.gestindeproductosapi.expose.schema.CreateProductResponse;
import com.example.gestindeproductosapi.expose.schema.ListProductsResponse;
import com.example.gestindeproductosapi.expose.schema.GetProductByIdResponse;
import com.example.gestindeproductosapi.config.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Validated
@RestController
@SuppressWarnings("unused")
@Tag(name = "Products", description = "the Products API")
public interface ProductsApi {

  /**
   * POST /products : Crear un nuevo producto
   * Crear un nuevo producto
   */
  @Operation(
      operationId = "createProduct",
      summary = "Crear un nuevo producto",
      description = "Crear un nuevo producto",
      tags = { "Products" },
      responses = {
          @ApiResponse(responseCode = "201", description = "Crear un nuevo producto", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CreateProductResponse.class)) }),
          @ApiResponse(responseCode = "400", description = "Solicitud inválida", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CreateProductResponse.class)) }),
          @ApiResponse(responseCode = "401", description = "No autenticado", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CreateProductResponse.class)) }),
          @ApiResponse(responseCode = "403", description = "Sin permisos", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CreateProductResponse.class)) }),
          @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CreateProductResponse.class)) })
      })
  @RequestMapping(method = RequestMethod.POST, value = "/products", produces = { "application/json" }, consumes = { "application/json" })
  Mono<CreateProductResponse> createProduct(@RequestBody @Valid CreateProductRequest request);

  /**
   * GET /products : Listar productos con paginación
   * Listar productos con paginación
   */
  @Operation(
      operationId = "listProducts",
      summary = "Listar productos con paginación",
      description = "Listar productos con paginación",
      tags = { "Products" },
      responses = {
          @ApiResponse(responseCode = "200", description = "Listar productos con paginación", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ListProductsResponse.class)) }),
          @ApiResponse(responseCode = "400", description = "Solicitud inválida", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ListProductsResponse.class)) }),
          @ApiResponse(responseCode = "401", description = "No autenticado", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ListProductsResponse.class)) }),
          @ApiResponse(responseCode = "403", description = "Sin permisos", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ListProductsResponse.class)) }),
          @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ListProductsResponse.class)) })
      })
  @RequestMapping(method = RequestMethod.GET, value = "/products", produces = { "application/json" })
  Mono<ListProductsResponse> listProducts(
    @RequestParam Integer page,
    @RequestParam Integer perPage,
    @RequestParam String search
  );

  /**
   * GET /products/{id} : Obtener detalle de un producto por ID
   * Obtener detalle de un producto por ID
   */
  @Operation(
      operationId = "getProductById",
      summary = "Obtener detalle de un producto por ID",
      description = "Obtener detalle de un producto por ID",
      tags = { "Products" },
      responses = {
          @ApiResponse(responseCode = "200", description = "Obtener detalle de un producto por ID", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = GetProductByIdResponse.class)) }),
          @ApiResponse(responseCode = "400", description = "Solicitud inválida", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = GetProductByIdResponse.class)) }),
          @ApiResponse(responseCode = "401", description = "No autenticado", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = GetProductByIdResponse.class)) }),
          @ApiResponse(responseCode = "403", description = "Sin permisos", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = GetProductByIdResponse.class)) }),
          @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = GetProductByIdResponse.class)) }),
          @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = GetProductByIdResponse.class)) })
      })
  @RequestMapping(method = RequestMethod.GET, value = "/products/{id}", produces = { "application/json" })
  Mono<GetProductByIdResponse> getProductById(@PathVariable UUID id);

  /**
   * DELETE /products/{id} : Eliminar producto (soft delete)
   * Eliminar producto (soft delete)
   */
  @Operation(
      operationId = "deleteProduct",
      summary = "Eliminar producto (soft delete)",
      description = "Eliminar producto (soft delete)",
      tags = { "Products" },
      responses = {
          @ApiResponse(responseCode = "204", description = "Eliminar producto (soft delete)"),
          @ApiResponse(responseCode = "400", description = "Solicitud inválida", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteProductResponse.class)) }),
          @ApiResponse(responseCode = "401", description = "No autenticado", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteProductResponse.class)) }),
          @ApiResponse(responseCode = "403", description = "Sin permisos", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteProductResponse.class)) }),
          @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteProductResponse.class)) }),
          @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteProductResponse.class)) })
      })
  @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
  Mono<Void> deleteProduct(@PathVariable UUID id);

}
