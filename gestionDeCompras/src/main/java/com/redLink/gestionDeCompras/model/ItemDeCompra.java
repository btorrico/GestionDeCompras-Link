
package com.redLink.gestionDeCompras.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
class ItemDeCompra {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idItem;
    @ManyToOne // Un producto puede ser parte de muchos items y un item corresponde a un producto
    private Producto producto;
    private double precioDeCompra;
    private int cantidad;
}
