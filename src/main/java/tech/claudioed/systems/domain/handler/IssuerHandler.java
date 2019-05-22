package tech.claudioed.systems.domain.handler;

import java.net.URI;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import tech.claudioed.systems.domain.Issuer;
import tech.claudioed.systems.domain.service.IssuerService;

/**
 * @author claudioed on 2019-05-21.
 * Project systems
 */
@Component
public class IssuerHandler {

  private final IssuerService issuerService;

  public IssuerHandler(IssuerService issuerService) {
    this.issuerService = issuerService;
  }

  public Mono<ServerResponse> find(ServerRequest request){
    return this.issuerService.find(request.pathVariable("id"))
        .flatMap(post -> ServerResponse.ok().body(Mono.just(post), Issuer.class))
        .switchIfEmpty(ServerResponse.notFound().build());
  }

  public Mono<ServerResponse> create(ServerRequest request){
    final Mono<Issuer> issuerMono = request.bodyToMono(Issuer.class);
    return issuerMono.flatMap(issuer -> this.issuerService.newIssuer(issuer))
        .flatMap(p -> ServerResponse.created(URI.create("/issuers/" + p.getId())).build());
  }

}
