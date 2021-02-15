package br.com.deliverit.desafio.infrastructure.repository;

import br.com.deliverit.desafio.domain.entity.Regra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável pela camada de repository
 */
@Repository
public interface RegraRepository extends JpaRepository<Regra, Long> {
}
