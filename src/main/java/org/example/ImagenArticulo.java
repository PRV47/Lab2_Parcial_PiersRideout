package org.example;

import javax.persistence.*;

@Entity
public class ImagenArticulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articuloImagen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Articulo getArticuloImagen() {
        return articuloImagen;
    }

    public void setArticuloImagen(Articulo articuloImagen) {
        this.articuloImagen = articuloImagen;
    }
}