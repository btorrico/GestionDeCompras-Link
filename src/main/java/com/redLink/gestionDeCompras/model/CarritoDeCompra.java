
package com.redLink.gestionDeCompras.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class CarritoDeCompra {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<ItemDeCompra> itemsDeCompra;   
    
    @Enumerated(EnumType.STRING)
    private MedioDePago medioDePago;
    private float subtotal;
    private float total;
    private int cantidad;
    private float precio;
    @ManyToMany
    private List<Promocion> promociones;
    @ManyToOne
    private Cliente cliente;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public CarritoDeCompra() {
    }

    public CarritoDeCompra(Long id, ArrayList<ItemDeCompra> itemsDeCompra, float subtotal) {
        this.id = id;
        this.itemsDeCompra = itemsDeCompra;
        this.subtotal = subtotal;
    }

    public CarritoDeCompra(ArrayList<ItemDeCompra> itemsDeCompra, float subtotal) {
        this.itemsDeCompra = itemsDeCompra;
        this.subtotal = subtotal;
    }
     
    
    
    public CarritoDeCompra(Long id, ArrayList<ItemDeCompra> itemsDeCompra, float subtotal, int total, int cantidad,
			float precio) {
		super();
		this.id = id;
		this.itemsDeCompra = itemsDeCompra;
		this.subtotal = subtotal;
		this.total = total;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public CarritoDeCompra(ArrayList<ItemDeCompra> itemsDeCompra) {
        this.itemsDeCompra = itemsDeCompra;
    }
    
    public void agregarProducto(ItemDeCompra nuevoItem){
        itemsDeCompra.add(nuevoItem);
        subtotal = subtotal + nuevoItem.precioPesos();
    }
    
    public void aplicarPromocion(Promocion nuevaPromo){
        subtotal*= 1 - nuevaPromo.descuento(this);
    }
    
    public void eliminarItemDeCompra( ItemDeCompra item){
        itemsDeCompra.remove(item);
    }
    
    public void vaciarCarritoDeCompra(){
        itemsDeCompra.clear();
    }
    
    public double costoTotalPesos() {
    	return itemsDeCompra.stream().mapToDouble(x->x.precioPesos()).sum();
    }
    public double costoTotalDolares() {
    	return itemsDeCompra.stream().mapToDouble(x->x.precioDolar()).sum();
    }
    
    public double aplicarDescuento() {
    	return this.costoTotalPesos() - promociones.stream().mapToDouble(x -> x.descuento(this)).sum();
    }

	public Double costoProductos(Proveedor proveedor) {
	 return itemsDeCompra.stream().filter(x->x.getProducto().getProveedor().equals(proveedor)).mapToDouble(x->x.precioPesos()).sum();
	}
}
