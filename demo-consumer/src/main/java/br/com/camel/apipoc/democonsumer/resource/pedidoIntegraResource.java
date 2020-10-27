package br.com.camel.apipoc.democonsumer.resource;

import br.com.camel.apipoc.democonsumer.domain.PedidoIntegra;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class pedidoIntegraResource {


    @GetMapping(value = "pedido")
    public PedidoIntegra getPedido(){
       return new PedidoIntegra(1l,"marco");

    }
}
