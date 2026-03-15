package com.example.gestindeproductosapi.delegate.impl;

import com.example.gestindeproductosapi.expose.controller.ProductsApiDelegate;
import com.example.gestindeproductosapi.business.ProductsService;
import com.example.gestindeproductosapi.expose.schema.CreateProductRequest;
import com.example.gestindeproductosapi.expose.schema.CreateProductResponse;
import com.example.gestindeproductosapi.expose.schema.ListProductsResponse;
import com.example.gestindeproductosapi.expose.schema.GetProductByIdResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@SuppressWarnings("all")
@RequiredArgsConstructor
public class ProductsApiDelegateImpl implements ProductsApiDelegate {

  private final ProductsService service;

  @Override
  public Mono<CreateProductResponse> createProduct(CreateProductRequest request) {
    return service.createProduct(request);
  }

  @Override
  public Mono<ListProductsResponse> listProducts(
    Integer page,
    Integer perPage,
    String search
  ) {
    return service.listProducts(page, perPage, search);
  }

  @Override
  public Mono<GetProductByIdResponse> getProductById(UUID id) {
    return service.getProductById(id);
  }

  @Override
  public Mono<Void> deleteProduct(UUID id) {
    return service.deleteProduct(id);
  }

}
