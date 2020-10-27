package br.com.camel.apipoc.demoproducer.repository;

import br.com.camel.apipoc.demoproducer.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
