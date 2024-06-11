package org.example;

import javax.persistence.*;

@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;
    private Double subTotal;

    @ManyToOne
    private Pedido pedidoDetalle;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Pedido getPedidoDetalle() {
        return pedidoDetalle;
    }

    public void setPedidoDetalle(Pedido pedidoDetalle) {
        this.pedidoDetalle = pedidoDetalle;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}