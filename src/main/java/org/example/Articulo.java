package org.example;


import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_articulo", discriminatorType = DiscriminatorType.STRING)
public abstract class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;
    private Double precioVenta;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoriaArticulo;

    @OneToMany(mappedBy = "articuloImagen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenArticulo> imagenesArticulo;

    @ManyToOne
    @JoinColumn(name = "unidad_medida_id")
    private UnidadMedida unidadMedida;


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

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Categoria getCategoriaArticulo() {
        return categoriaArticulo;
    }

    public void setCategoriaArticulo(Categoria categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }

    public List<ImagenArticulo> getImagenesArticulo() {
        return imagenesArticulo;
    }

    public void setImagenesArticulo(List<ImagenArticulo> imagenesArticulo) {
        this.imagenesArticulo = imagenesArticulo;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}
