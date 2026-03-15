package com.example.gestindeproductosapi.expose.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  public static final String EXAMPLE = "{\"createdAt\":\"2023-10-01T12:00:00Z\",\"updatedAt\":\"2023-10-01T12:00:00Z\",\"createdBy\":\"user-uuid\",\"updatedBy\":\"user-uuid\",\"isDeleted\":false,\"deletedAt\":null,\"id\":\"product-uuid\",\"name\":\"Laptop Dell XPS\",\"description\":\"Laptop de alto rendimiento\",\"brandId\":\"brand-uuid\",\"categoryId\":\"category-uuid\",\"unitMeasureId\":\"unit-measure-uuid\",\"price\":1200,\"stock\":10}";

  @JsonProperty("createdAt")
  private LocalDateTime createdAt;

  @JsonProperty("updatedAt")
  private LocalDateTime updatedAt;

  @JsonProperty("createdBy")
  private UUID createdBy;

  @JsonProperty("updatedBy")
  private UUID updatedBy;

  @JsonProperty("isDeleted")
  private Boolean isDeleted;

  @JsonProperty("deletedAt")
  private LocalDateTime deletedAt;

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("brandId")
  private UUID brandId;

  @JsonProperty("categoryId")
  private UUID categoryId;

  @JsonProperty("unitMeasureId")
  private UUID unitMeasureId;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("stock")
  private Integer stock;

}
