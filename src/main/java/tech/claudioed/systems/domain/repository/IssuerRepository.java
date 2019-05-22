package tech.claudioed.systems.domain.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import tech.claudioed.systems.domain.Issuer;

/** @author claudioed on 2019-05-21. Project systems */
public interface IssuerRepository extends ReactiveCrudRepository<Issuer, String> {}
