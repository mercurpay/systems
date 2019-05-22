package tech.claudioed.systems.infra.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import tech.claudioed.systems.domain.handler.IssuerHandler;

/**
 * @author claudioed on 2019-05-21.
 * Project systems
 */
@Configuration
public class IssuerRouter {

  @Bean
  public RouterFunction<ServerResponse> root(IssuerHandler issuerHandler) {
    return RouterFunctions.route()
        .GET("/issuers/{id}", accept(MediaType.APPLICATION_JSON), issuerHandler::find)
        .POST("/issuers", accept(MediaType.APPLICATION_JSON), issuerHandler::create)
        .build();
  }

}
