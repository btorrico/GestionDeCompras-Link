
package com.redLink.gestionDeCompras.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class CuponDescuento extends Promocion {

	private Double valor;
	private boolean fueUtilizado;
	@ManyToOne
	private Proveedor proveedor;
	
	
	
	public CuponDescuento() {
		super();
	}



	public CuponDescuento(boolean fueUtilizado) {
		super();
		this.fueUtilizado = false;
	}



	public CuponDescuento(Double valor, boolean fueUtilizado) {
		super();
		this.valor = valor;
		this.fueUtilizado = false;
	}



	public CuponDescuento(Double valor, boolean fueUtilizado, Proveedor proveedor) {
		super();
		this.valor = valor;
		this.fueUtilizado = false;
		this.proveedor = proveedor;
	}



	@Override
	public Double descuento(CarritoDeCompra carritoDeCompra) {
		 if(this.fueUtilizado) {
			 return 0.0;
		 }else {
			 if(this.valor <= carritoDeCompra.costoProductos(proveedor)) {
				 this.usarCupon();
				 return this.valor;
			 }else {
				 this.usarCupon();
				 return carritoDeCompra.costoProductos(proveedor);
			 }
			 
		 }
	}



	public void usarCupon() {
       this.fueUtilizado = true;		
	}
    
}
