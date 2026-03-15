package com.example.gestindeproductosapi.expose.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListProductsResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  public static final String EXAMPLE = "{\"data\":[],\"pagination\":{\"page\":1,\"perPage\":10,\"totalItems\":100,\"totalPages\":10,\"hasNext\":true,\"hasPrev\":false}}";

  @JsonProperty("data")
  private List<DataItem> data;

  @JsonProperty("pagination")
  private Pagination pagination;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class DataItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Pagination implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("perPage")
    private Integer perPage;

    @JsonProperty("totalItems")
    private Integer totalItems;

    @JsonProperty("totalPages")
    private Integer totalPages;

    @JsonProperty("hasNext")
    private Boolean hasNext;

    @JsonProperty("hasPrev")
    private Boolean hasPrev;

  }

}
