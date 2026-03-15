package com.example.gestindeproductosapi.business;

import com.example.gestindeproductosapi.expose.schema.CreateProductRequest;
import com.example.gestindeproductosapi.expose.schema.CreateProductResponse;
import com.example.gestindeproductosapi.expose.schema.ListProductsResponse;
import com.example.gestindeproductosapi.expose.schema.GetProductByIdResponse;
import reactor.core.publisher.Mono;

public interface ProductsService {

  Mono<CreateProductResponse> createProduct(CreateProductRequest request);

  Mono<ListProductsResponse> listProducts(
    Integer page,
    Integer perPage,
    String search
  );

  Mono<GetProductByIdResponse> getProductById(UUID id);

  Mono<Void> deleteProduct(UUID id);

}
