package com.example.gestindeproductosapi.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

  private String trace;
  private LocalDateTime timestamp;
  private Integer status;
  private String code;
  private String message;
  private String path;
  private String detail;

}
