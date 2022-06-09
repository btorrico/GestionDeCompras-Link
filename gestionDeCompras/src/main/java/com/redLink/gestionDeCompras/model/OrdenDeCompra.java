
package com.redLink.gestionDeCompras.model;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class OrdenDeCompra {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idOrdenDeCompra;
    private String idFactura;
    @OneToMany // Una orden de compra puede tener muchos items pero un item pertenece a una sola orden de compra
    private Collection<ItemDeCompra> itemsDeCompra;
    private LocalDate fechaDeCompra;
    private Collection<Promocion> promocionesAplicadas;
    private MedioDePago medioDePago;
    // private Proveedor proveedor; Lo estoy viendo
    
}
