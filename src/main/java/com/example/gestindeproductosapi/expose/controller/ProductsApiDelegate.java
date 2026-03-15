package com.example.gestindeproductosapi.expose.controller;

import com.example.gestindeproductosapi.expose.schema.CreateProductRequest;
import com.example.gestindeproductosapi.expose.schema.CreateProductResponse;
import com.example.gestindeproductosapi.expose.schema.ListProductsResponse;
import com.example.gestindeproductosapi.expose.schema.GetProductByIdResponse;
import reactor.core.publisher.Mono;

public interface ProductsApiDelegate {

  /**
   * POST /products : Crear un nuevo producto
   * Crear un nuevo producto
   */
  Mono<CreateProductResponse> createProduct(CreateProductRequest request);

  /**
   * GET /products : Listar productos con paginación
   * Listar productos con paginación
   */
  Mono<ListProductsResponse> listProducts(
    Integer page,
    Integer perPage,
    String search
  );

  /**
   * GET /products/{id} : Obtener detalle de un producto por ID
   * Obtener detalle de un producto por ID
   */
  Mono<GetProductByIdResponse> getProductById(UUID id);

  /**
   * DELETE /products/{id} : Eliminar producto (soft delete)
   * Eliminar producto (soft delete)
   */
  Mono<Void> deleteProduct(UUID id);

}
