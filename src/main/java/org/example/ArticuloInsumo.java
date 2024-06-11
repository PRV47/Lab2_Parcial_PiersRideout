package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("INSUMO")
public class ArticuloInsumo extends Articulo {
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esParaElaborar;

    @OneToMany(mappedBy = "articuloInsumo")
    private List<ArticuloManufacturadoDetalle> detalles;

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public Boolean getEsParaElaborar() {
        return esParaElaborar;
    }

    public void setEsParaElaborar(Boolean esParaElaborar) {
        this.esParaElaborar = esParaElaborar;
    }

    public List<ArticuloManufacturadoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ArticuloManufacturadoDetalle> detalles) {
        this.detalles = detalles;
    }
}
