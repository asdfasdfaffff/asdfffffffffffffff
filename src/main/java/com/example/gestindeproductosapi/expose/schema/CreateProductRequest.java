package com.example.gestindeproductosapi.expose.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  public static final String EXAMPLE = "{\"name\":\"Laptop Dell XPS\",\"description\":\"Laptop de alto rendimiento\",\"brandId\":\"brand-uuid\",\"categoryId\":\"category-uuid\",\"unitMeasureId\":\"unit-measure-uuid\",\"price\":1200,\"stock\":10}";

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
