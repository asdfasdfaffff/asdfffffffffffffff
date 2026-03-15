package com.example.gestindeproductosapi.expose.controller;

import com.example.gestindeproductosapi.expose.schema.CreateProductRequest;
import com.example.gestindeproductosapi.expose.schema.CreateProductResponse;
import com.example.gestindeproductosapi.expose.schema.ListProductsResponse;
import com.example.gestindeproductosapi.expose.schema.GetProductByIdResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Getter
@RestController
@SuppressWarnings("unused")
public class ProductsApiController implements ProductsApi {

  private final ProductsApiDelegate delegate;

  public ProductsApiController(@Autowired(required = false) ProductsApiDelegate delegate) {
    this.delegate = delegate;
  }

  /**
   * POST /products : Crear un nuevo producto
   * Crear un nuevo producto
   */
  @Override
  public Mono<CreateProductResponse> createProduct(@RequestBody @Valid CreateProductRequest request) {
    return getDelegate().createProduct(request);
  }

  /**
   * GET /products : Listar productos con paginación
   * Listar productos con paginación
   */
  @Override
  public Mono<ListProductsResponse> listProducts(
    @RequestParam Integer page,
    @RequestParam Integer perPage,
    @RequestParam String search
  ) {
    return getDelegate().listProducts(page, perPage, search);
  }

  /**
   * GET /products/{id} : Obtener detalle de un producto por ID
   * Obtener detalle de un producto por ID
   */
  @Override
  public Mono<GetProductByIdResponse> getProductById(@PathVariable UUID id) {
    return getDelegate().getProductById(id);
  }

  /**
   * DELETE /products/{id} : Eliminar producto (soft delete)
   * Eliminar producto (soft delete)
   */
  @Override
  public Mono<Void> deleteProduct(@PathVariable UUID id) {
    return getDelegate().deleteProduct(id);
  }

}
