package tech.claudioed.systems.domain.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import tech.claudioed.systems.domain.Crm;

/**
 * @author claudioed on 2019-05-26.
 * Project systems
 */
public interface CrmRepository  extends ReactiveCrudRepository<Crm, String> {}
