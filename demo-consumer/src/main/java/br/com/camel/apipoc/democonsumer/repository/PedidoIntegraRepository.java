package br.com.camel.apipoc.democonsumer.repository;

import br.com.camel.apipoc.democonsumer.domain.PedidoIntegra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoIntegraRepository extends JpaRepository<PedidoIntegra, Long> {
}
