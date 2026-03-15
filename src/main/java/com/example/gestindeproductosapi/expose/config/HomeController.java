package com.example.gestindeproductosapi.expose.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import java.net.URI;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Controller
@SuppressWarnings("unused")
public class HomeController {

  @Bean
  RouterFunction<ServerResponse> index() {
    return route(
        GET("/"),
        req -> ServerResponse.temporaryRedirect(URI.create("swagger-ui.html")).build()
    );
  }

}
