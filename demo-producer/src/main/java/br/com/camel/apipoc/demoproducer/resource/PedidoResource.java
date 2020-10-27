package br.com.camel.apipoc.demoproducer.resource;

import br.com.camel.apipoc.demoproducer.domain.Pedido;
import br.com.camel.apipoc.demoproducer.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pedido")
public class PedidoResource {

    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping
    public ResponseEntity<?> novoPedido(@RequestBody Pedido pedido){

        var novoPedido = pedidoRepository.save(pedido);

        return ResponseEntity.ok(pedido);
    }
}
