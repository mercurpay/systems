package tech.claudioed.systems.domain.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tech.claudioed.systems.domain.Crm;
import tech.claudioed.systems.domain.repository.CrmRepository;

/**
 * @author claudioed on 2019-05-21.
 * Project systems
 */
@Service
public class CrmService {

  private final CrmRepository crmRepository;

  public CrmService(CrmRepository crmRepository) {
    this.crmRepository = crmRepository;
  }

  public Mono<Crm> newCrm(Crm crm){
    return this.crmRepository.save(crm);
  }

  public Mono<Crm> find(String id){
    return this.crmRepository.findById(id);
  }

}
