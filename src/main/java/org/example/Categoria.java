package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;

    @OneToMany(mappedBy = "categoriaArticulo")
    private List<Articulo> articulos;

    @ManyToMany(mappedBy = "categoriasSucursal")
    private List<Sucursal> sucursales;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Categoria parent;

    @OneToMany(mappedBy = "parent")
    private List<Categoria> subcategorias;

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

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}