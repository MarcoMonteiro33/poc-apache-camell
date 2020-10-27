package br.com.camel.apipoc.democonsumer.domain;

import org.apache.camel.component.jpa.Consumed;

import javax.persistence.*;

@Entity
@NamedQuery(name="pedidoPendente", query = "select p from PedidoIntegra p where p.tpStatus = 'A'")
public class PedidoIntegra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    private String comprador;

    private String tpStatus;

    public PedidoIntegra() {
    }

    public PedidoIntegra(Long codigo, String comprador) {
        this.codigo = codigo;
        this.comprador = comprador;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getTpStatus() {
        return tpStatus;
    }

    @Consumed
    public void setTpStatus() {
        this.tpStatus = "T";
    }
}
