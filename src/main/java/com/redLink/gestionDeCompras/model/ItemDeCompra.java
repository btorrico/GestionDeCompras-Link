
package com.redLink.gestionDeCompras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
 public class ItemDeCompra {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idItem;
    @ManyToOne // Un producto puede ser parte de muchos items y un item corresponde a un producto
    private Producto producto;
    private Float precioDeCompra;
    private int cantidadProducto;
    @ManyToOne
    @JoinColumn(name = "ordenDeCompra_id")
    private OrdenDeCompra ordenDeCompra;

    public ItemDeCompra() {
    }

    public ItemDeCompra(Long idItem, Producto producto, Float precioDeCompra, int cantidadProducto, OrdenDeCompra ordenDeCompra) {
        this.idItem = idItem;
        this.producto = producto;
        this.precioDeCompra = precioDeCompra;
        this.cantidadProducto = cantidadProducto;
        this.ordenDeCompra = ordenDeCompra;
    }

    public ItemDeCompra(Producto producto, Float precioDeCompra, int cantidadProducto, OrdenDeCompra ordenDeCompra) {
        this.producto = producto;
        this.precioDeCompra = precioDeCompra;
        this.cantidadProducto = cantidadProducto;
        this.ordenDeCompra = ordenDeCompra;
    }

    public ItemDeCompra(Producto producto, int cantidadProducto, OrdenDeCompra ordenDeCompra) {
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.ordenDeCompra = ordenDeCompra;
    }
    
    public Float precioPesos(){
        return producto.getPrecioPesos() * this.cantidadProducto;
    }
    
    public Float precioDolar(){
        return producto.getPrecioDolar() * this.cantidadProducto;
    }

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Producto getProducto() {
		return producto;
	}




    
}
