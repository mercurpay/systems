package tech.claudioed.systems.domain.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tech.claudioed.systems.domain.Issuer;
import tech.claudioed.systems.domain.repository.IssuerRepository;

/**
 * @author claudioed on 2019-05-21.
 * Project systems
 */
@Service
public class IssuerService {

  private final IssuerRepository issuerRepository;

  public IssuerService(IssuerRepository issuerRepository) {
    this.issuerRepository = issuerRepository;
  }

  public Mono<Issuer> newIssuer(Issuer issuer){
    return this.issuerRepository.save(issuer);
  }

  public Mono<Issuer> find(String id){
    return this.issuerRepository.findById(id);
  }

}
