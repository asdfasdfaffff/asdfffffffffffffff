package com.example.gestindeproductosapi.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Component
@Order(-100)
@SuppressWarnings("unused")
public class TraceWebFilter implements WebFilter {

  public static final String TRACE_HEADER = "X-Trace-Id";
  public static final String MDC_KEY = "traceId";

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    String traceId = request.getHeaders().getFirst(TRACE_HEADER);
    if (traceId == null || traceId.isBlank()) {
      traceId = UUID.randomUUID().toString();
    }
    final String finalTraceId = traceId;
    exchange.getAttributes().put(MDC_KEY, finalTraceId);
    exchange.getResponse().getHeaders().add(TRACE_HEADER, finalTraceId);
    MDC.put(MDC_KEY, finalTraceId);
    return chain.filter(exchange)
        .doFinally(signal -> MDC.remove(MDC_KEY));
  }

}
