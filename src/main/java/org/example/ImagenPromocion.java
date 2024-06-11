package org.example;

import javax.persistence.*;

@Entity
public class ImagenPromocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "promocion_id")
    private Promocion promocionImagen;
}