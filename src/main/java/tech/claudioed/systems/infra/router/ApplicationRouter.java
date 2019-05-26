package tech.claudioed.systems.infra.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import tech.claudioed.systems.domain.handler.CrmHandler;
import tech.claudioed.systems.domain.handler.IssuerHandler;

/**
 * @author claudioed on 2019-05-21.
 * Project systems
 */
@Configuration
public class ApplicationRouter {

  @Bean
  public RouterFunction<ServerResponse> root(IssuerHandler issuerHandler, CrmHandler crmHandler) {
    return RouterFunctions.route()
        .GET("/issuers/{id}", accept(MediaType.APPLICATION_JSON), issuerHandler::find)
        .POST("/issuers", accept(MediaType.APPLICATION_JSON), issuerHandler::create)
        .GET("/crms/{id}", accept(MediaType.APPLICATION_JSON), crmHandler::find)
        .POST("/crms", accept(MediaType.APPLICATION_JSON), crmHandler::create)
        .build();
  }

}
