package com.example.gestindeproductosapi.expose.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.UUID;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProductByIdResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  public static final String EXAMPLE = "{\"id\":\"product-uuid\",\"name\":\"Laptop Dell XPS\",\"description\":\"Laptop de alto rendimiento\",\"createdAt\":\"2023-10-01T12:00:00Z\",\"updatedAt\":\"2023-10-01T12:00:00Z\",\"responsible\":{\"id\":\"user-uuid\",\"name\":\"Juan Pérez\"}}";

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("createdAt")
  private LocalDateTime createdAt;

  @JsonProperty("updatedAt")
  private LocalDateTime updatedAt;

  @JsonProperty("responsible")
  private Responsible responsible;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Responsible implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;

  }

}
