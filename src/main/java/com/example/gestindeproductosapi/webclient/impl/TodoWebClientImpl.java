package com.example.gestindeproductosapi.webclient.impl;

import com.example.gestindeproductosapi.webclient.TodoWebClient;
import com.example.gestindeproductosapi.webclient.config.ApiWebClientProperties;
import com.example.gestindeproductosapi.webclient.reqres.TodoWcRequest;
import com.example.gestindeproductosapi.webclient.reqres.TodoWcResponse;
import com.example.gestindeproductosapi.business.exception.BusinessException;
import com.example.gestindeproductosapi.business.exception.BusinessErrorCodes;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
@SuppressWarnings("unused")
@RequiredArgsConstructor
public class TodoWebClientImpl implements TodoWebClient {

	private final WebClient apiWebClient;
	private final ApiWebClientProperties properties;

	@Override
	public Mono<TodoWcResponse> getExample(String id, String filter, String authorization) {
		ApiWebClientProperties.PathConfig cfg = properties.getPaths().get("getExample");

		return apiWebClient
						.get()
						.uri(UriComponentsBuilder
									.fromUriString(cfg.getUrl())
									.queryParam("filter", filter)
									.buildAndExpand(id)
									.toUriString())
						.headers(h -> {
							h.setBearerAuth(authorization);
							cfg.getHeaders().forEach(h::add);
						})
						.retrieve()
				.onStatus(
							HttpStatusCode::is4xxClientError,
							r -> r.bodyToMono(String.class)
										.doOnNext(body -> log.warn("[TodoWebClient] 4xx: {}", body))
										.flatMap(body -> Mono.error(BusinessException.of(HttpStatus.BAD_GATEWAY, BusinessErrorCodes.EXTERNAL_API_ERROR, body))))
				.onStatus(
							HttpStatusCode::is5xxServerError,
							r -> r.bodyToMono(String.class)
										.doOnNext(body -> log.error("[TodoWebClient] 5xx: {}", body))
										.flatMap(body -> Mono.error(BusinessException.of(HttpStatus.SERVICE_UNAVAILABLE, BusinessErrorCodes.EXTERNAL_API_ERROR, body))))
						.bodyToMono(TodoWcResponse.class)
						.timeout(Duration.ofSeconds(cfg.getReadTimeoutSeconds()))
						.doOnNext(r -> log.info("[TodoWebClient] getExample OK"))
						.onErrorMap(e -> !(e instanceof BusinessException), e -> BusinessException.of(HttpStatus.SERVICE_UNAVAILABLE, BusinessErrorCodes.EXTERNAL_API_ERROR, e.getMessage()))
						.doOnError(e -> log.error("[TodoWebClient] getExample ERROR: {}", e.getMessage()));
	}

	@Override
	public Mono<TodoWcResponse> postExample(TodoWcRequest request, String authorization) {
		ApiWebClientProperties.PathConfig cfg = properties.getPaths().get("postExample");

		return apiWebClient
						.post()
						.uri(cfg.getUrl())
						.headers(h -> {
							h.setContentType(MediaType.APPLICATION_JSON);
							h.setBearerAuth(authorization);
							cfg.getHeaders().forEach(h::add);
						})
						.bodyValue(request)
						.retrieve()
				.onStatus(
							HttpStatusCode::is4xxClientError,
							r -> r.bodyToMono(String.class)
										.doOnNext(body -> log.warn("[TodoWebClient] 4xx: {}", body))
										.flatMap(body -> Mono.error(BusinessException.of(HttpStatus.BAD_GATEWAY, BusinessErrorCodes.EXTERNAL_API_ERROR, body))))
				.onStatus(
							HttpStatusCode::is5xxServerError,
							r -> r.bodyToMono(String.class)
										.doOnNext(body -> log.error("[TodoWebClient] 5xx: {}", body))
										.flatMap(body -> Mono.error(BusinessException.of(HttpStatus.SERVICE_UNAVAILABLE, BusinessErrorCodes.EXTERNAL_API_ERROR, body))))
						.bodyToMono(TodoWcResponse.class)
						.timeout(Duration.ofSeconds(cfg.getReadTimeoutSeconds()))
						.doOnNext(r -> log.info("[TodoWebClient] postExample OK"))
						.onErrorMap(e -> !(e instanceof BusinessException), e -> BusinessException.of(HttpStatus.SERVICE_UNAVAILABLE, BusinessErrorCodes.EXTERNAL_API_ERROR, e.getMessage()))
						.doOnError(e -> log.error("[TodoWebClient] postExample ERROR: {}", e.getMessage()));
	}

	@Override
	public Mono<TodoWcResponse> putExample(String id, TodoWcRequest request, String authorization) {
		ApiWebClientProperties.PathConfig cfg = properties.getPaths().get("putExample");

		return apiWebClient
						.put()
						.uri(UriComponentsBuilder
									.fromUriString(cfg.getUrl())
									.buildAndExpand(id)
									.toUriString())
						.headers(h -> {
							h.setContentType(MediaType.APPLICATION_JSON);
							h.setBearerAuth(authorization);
							cfg.getHeaders().forEach(h::add);
						})
						.bodyValue(request)
						.retrieve()
				.onStatus(
							HttpStatusCode::is4xxClientError,
							r -> r.bodyToMono(String.class)
										.doOnNext(body -> log.warn("[TodoWebClient] 4xx: {}", body))
										.flatMap(body -> Mono.error(BusinessException.of(HttpStatus.BAD_GATEWAY, BusinessErrorCodes.EXTERNAL_API_ERROR, body))))
				.onStatus(
							HttpStatusCode::is5xxServerError,
							r -> r.bodyToMono(String.class)
										.doOnNext(body -> log.error("[TodoWebClient] 5xx: {}", body))
										.flatMap(body -> Mono.error(BusinessException.of(HttpStatus.SERVICE_UNAVAILABLE, BusinessErrorCodes.EXTERNAL_API_ERROR, body))))
						.bodyToMono(TodoWcResponse.class)
						.timeout(Duration.ofSeconds(cfg.getReadTimeoutSeconds()))
						.doOnNext(r -> log.info("[TodoWebClient] putExample OK"))
						.onErrorMap(e -> !(e instanceof BusinessException), e -> BusinessException.of(HttpStatus.SERVICE_UNAVAILABLE, BusinessErrorCodes.EXTERNAL_API_ERROR, e.getMessage()))
						.doOnError(e -> log.error("[TodoWebClient] putExample ERROR: {}", e.getMessage()));
	}

	@Override
	public Mono<TodoWcResponse> patchExample(String id, TodoWcRequest request, String authorization) {
		ApiWebClientProperties.PathConfig cfg = properties.getPaths().get("patchExample");

		return apiWebClient
						.patch()
						.uri(UriComponentsBuilder
									.fromUriString(cfg.getUrl())
									.buildAndExpand(id)
									.toUriString())
						.headers(h -> {
							h.setContentType(MediaType.APPLICATION_JSON);
							h.setBearerAuth(authorization);
							cfg.getHeaders().forEach(h::add);
						})
						.bodyValue(request)
						.retrieve()
				.onStatus(
							HttpStatusCode::is4xxClientError,
							r -> r.bodyToMono(String.class)
										.doOnNext(body -> log.warn("[TodoWebClient] 4xx: {}", body))
										.flatMap(body -> Mono.error(BusinessException.of(HttpStatus.BAD_GATEWAY, BusinessErrorCodes.EXTERNAL_API_ERROR, body))))
				.onStatus(
							HttpStatusCode::is5xxServerError,
							r -> r.bodyToMono(String.class)
										.doOnNext(body -> log.error("[TodoWebClient] 5xx: {}", body))
										.flatMap(body -> Mono.error(BusinessException.of(HttpStatus.SERVICE_UNAVAILABLE, BusinessErrorCodes.EXTERNAL_API_ERROR, body))))
						.bodyToMono(TodoWcResponse.class)
						.timeout(Duration.ofSeconds(cfg.getReadTimeoutSeconds()))
						.doOnNext(r -> log.info("[TodoWebClient] patchExample OK"))
						.onErrorMap(e -> !(e instanceof BusinessException), e -> BusinessException.of(HttpStatus.SERVICE_UNAVAILABLE, BusinessErrorCodes.EXTERNAL_API_ERROR, e.getMessage()))
						.doOnError(e -> log.error("[TodoWebClient] patchExample ERROR: {}", e.getMessage()));
	}

	@Override
	public Mono<Void> deleteExample(String id, String authorization) {
		ApiWebClientProperties.PathConfig cfg = properties.getPaths().get("deleteExample");

		return apiWebClient
						.delete()
						.uri(UriComponentsBuilder
									.fromUriString(cfg.getUrl())
									.buildAndExpand(id)
									.toUriString())
						.headers(h -> {
							h.setBearerAuth(authorization);
							cfg.getHeaders().forEach(h::add);
						})
						.retrieve()
				.onStatus(
							HttpStatusCode::is4xxClientError,
							r -> r.bodyToMono(String.class)
										.doOnNext(body -> log.warn("[TodoWebClient] 4xx: {}", body))
										.flatMap(body -> Mono.error(BusinessException.of(HttpStatus.BAD_GATEWAY, BusinessErrorCodes.EXTERNAL_API_ERROR, body))))
				.onStatus(
							HttpStatusCode::is5xxServerError,
							r -> r.bodyToMono(String.class)
										.doOnNext(body -> log.error("[TodoWebClient] 5xx: {}", body))
										.flatMap(body -> Mono.error(BusinessException.of(HttpStatus.SERVICE_UNAVAILABLE, BusinessErrorCodes.EXTERNAL_API_ERROR, body))))
						.bodyToMono(Void.class)
						.timeout(Duration.ofSeconds(cfg.getReadTimeoutSeconds()))
						.doOnNext(r -> log.info("[TodoWebClient] deleteExample OK"))
						.onErrorMap(e -> !(e instanceof BusinessException), e -> BusinessException.of(HttpStatus.SERVICE_UNAVAILABLE, BusinessErrorCodes.EXTERNAL_API_ERROR, e.getMessage()))
						.doOnError(e -> log.error("[TodoWebClient] deleteExample ERROR: {}", e.getMessage()));
	}

}
