
package com.redLink.gestionDeCompras.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarritoDeCompra {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //Tendria que tener los productos cargados para despues poder pasarselos a la
    //orden de compra cuando esta se genere?
}
