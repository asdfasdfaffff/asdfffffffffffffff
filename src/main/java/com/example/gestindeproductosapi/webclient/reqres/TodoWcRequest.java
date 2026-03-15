package com.example.gestindeproductosapi.webclient.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoWcRequest {

  @JsonProperty("field")
  private String field;

}
