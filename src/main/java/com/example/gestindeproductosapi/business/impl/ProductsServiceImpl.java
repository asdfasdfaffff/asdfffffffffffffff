package com.example.gestindeproductosapi.business.impl;

import com.example.gestindeproductosapi.business.ProductsService;
import com.example.gestindeproductosapi.expose.schema.CreateProductRequest;
import com.example.gestindeproductosapi.expose.schema.CreateProductResponse;
import com.example.gestindeproductosapi.expose.schema.ListProductsResponse;
import com.example.gestindeproductosapi.expose.schema.GetProductByIdResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class ProductsServiceImpl implements ProductsService {

  private final ObjectMapper objectMapper;

  @Override
  @SneakyThrows
  public Mono<CreateProductResponse> createProduct(CreateProductRequest request) {
    return Mono.just(objectMapper.readValue(CreateProductResponse.EXAMPLE, CreateProductResponse.class));
  }

  @Override
  @SneakyThrows
  public Mono<ListProductsResponse> listProducts(
    Integer page,
    Integer perPage,
    String search
  ) {
    return Mono.just(objectMapper.readValue(ListProductsResponse.EXAMPLE, ListProductsResponse.class));
  }

  @Override
  @SneakyThrows
  public Mono<GetProductByIdResponse> getProductById(UUID id) {
    return Mono.just(objectMapper.readValue(GetProductByIdResponse.EXAMPLE, GetProductByIdResponse.class));
  }

  @Override
  public Mono<Void> deleteProduct(UUID id) {
    return Mono.empty();
  }

}
