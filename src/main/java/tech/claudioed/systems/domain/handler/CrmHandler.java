package tech.claudioed.systems.domain.handler;

import java.net.URI;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import tech.claudioed.systems.domain.Crm;
import tech.claudioed.systems.domain.service.CrmService;

/**
 * @author claudioed on 2019-05-21.
 * Project systems
 */
@Component
public class CrmHandler {

  private final CrmService crmService;

  public CrmHandler(CrmService crmService) {
    this.crmService = crmService;
  }

  public Mono<ServerResponse> find(ServerRequest request){
    return this.crmService.find(request.pathVariable("id"))
        .flatMap(post -> ServerResponse.ok().body(Mono.just(post), Crm.class))
        .switchIfEmpty(ServerResponse.notFound().build());
  }

  public Mono<ServerResponse> create(ServerRequest request){
    final Mono<Crm> crmMono = request.bodyToMono(Crm.class);
    return crmMono.flatMap(issuer -> this.crmService.newCrm(issuer))
        .flatMap(p -> ServerResponse.created(URI.create("/crms/" + p.getId())).build());
  }

}
