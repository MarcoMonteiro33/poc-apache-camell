package br.com.camel.apipoc.democonsumer.route;


import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class PedidoRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("rest")
                .host("localhost").port(8080)
                .bindingMode(RestBindingMode.json);

        from("jpa:br.com.camel.apipoc.democonsumer.domain.PedidoIntegra"
                + "?namedQuery=pedidoPendente"
                + "&delay=20000"
                + "&consumeDelete=false")
                .routeId("route-saida-pedido")
                .log("Procesando o Pedido order #id ${body.codigo} with ${body.comprador}")
                .to("direct:integra-pedido");

        from("direct:integra-pedido")
        .routeId("rota-integra")
        .setHeader(Exchange.HTTP_METHOD, constant("POST"))
        .setHeader(Exchange.CONTENT_TYPE,constant("application/json"))
        .to("rest:post:/pedido")
        .log("enviado");


    }
}
