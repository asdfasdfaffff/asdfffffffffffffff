package com.example.gestindeproductosapi.expose.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  public static final String EXAMPLE = "{\"id\":\"1\",\"title\":\"Buy groceries\",\"status\":\"ACTIVE\"}";

  @JsonProperty("id")
  private String id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("status")
  private String status;

}
