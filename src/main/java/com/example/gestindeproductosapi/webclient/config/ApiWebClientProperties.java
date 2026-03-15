package com.example.gestindeproductosapi.webclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "webclient.api")
public class ApiWebClientProperties {

  private String baseUrl = "";
  private long connectTimeoutSeconds = 5;
  private Map<String, PathConfig> paths = new HashMap<>();

  @Data
  public static class PathConfig {
    private String url = "";
    private long connectTimeoutSeconds = 5;
    private long readTimeoutSeconds = 30;
    private long writeTimeoutSeconds = 30;
    private int retryMaxAttempts = 3;
    private long retryDelaySeconds = 1;
    private Map<String, String> headers = new HashMap<>();
  }

}
