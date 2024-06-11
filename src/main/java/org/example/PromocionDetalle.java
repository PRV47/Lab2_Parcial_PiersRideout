package org.example;

import javax.persistence.*;

@Entity
public class PromocionDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "promocion_id")
    private Promocion promocionDetail;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Promocion getPromocionDetail() {
        return promocionDetail;
    }

    public void setPromocionDetail(Promocion promocionDetail) {
        this.promocionDetail = promocionDetail;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
