
package com.redLink.gestionDeCompras.model;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Membresia extends Promocion{

	@Override
	public Double descuento(CarritoDeCompra carritoDeCompra) {
		// TODO Auto-generated method stub
		return null;
	}
    
  //  private Cliente cliente;
    
    

/*
    
    public Membresia() {
    }

    public Membresia(Cliente cliente) {
        super();
        this.cliente = cliente;
    }
    
        //falta metodo para realizar descuento
*/
}
