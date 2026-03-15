package com.example.gestindeproductosapi.webclient.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class WebClientConfig {

  private final ApiWebClientProperties properties;

  @Bean
  public WebClient apiWebClient() {
    HttpClient httpClient = HttpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, (int) (properties.getConnectTimeoutSeconds() * 1000))
        .responseTimeout(Duration.ofSeconds(60))
        .doOnConnected(conn -> conn
            .addHandlerLast(new ReadTimeoutHandler(60, TimeUnit.SECONDS))
            .addHandlerLast(new WriteTimeoutHandler(60, TimeUnit.SECONDS)));

    return WebClient.builder()
        .baseUrl(properties.getBaseUrl())
        .clientConnector(new ReactorClientHttpConnector(httpClient))
        .filter(logRequest())
        .filter(logResponse())
        .build();
  }

  private ExchangeFilterFunction logRequest() {
    return ExchangeFilterFunction.ofRequestProcessor(request -> {
      log.info("[WebClient] → {} {}", request.method(), request.url());
      return Mono.just(request);
    });
  }

  private ExchangeFilterFunction logResponse() {
    return ExchangeFilterFunction.ofResponseProcessor(response -> {
      log.info("[WebClient] ← Status: {}", response.statusCode());
      return Mono.just(response);
    });
  }

}
