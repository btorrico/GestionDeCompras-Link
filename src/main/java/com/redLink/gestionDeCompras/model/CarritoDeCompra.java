
package com.redLink.gestionDeCompras.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class CarritoDeCompra {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private ArrayList<ItemDeCompra> itemsDeCompra;
    private float subtotal;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    //Tendria que tener los productos cargados para despues poder pasarselos a la
    //orden de compra cuando esta se genere?

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

    public CarritoDeCompra(ArrayList<ItemDeCompra> itemsDeCompra) {
        this.itemsDeCompra = itemsDeCompra;
    }
    
    public void agregarProducto(ItemDeCompra nuevoItem){
        itemsDeCompra.add(nuevoItem);
        subtotal = subtotal + nuevoItem.precioPesos();
    }
    
    public void aplicarPromocion(Promocion nuevaPromo){
        subtotal*= 1 - nuevaPromo.descuento();
    }
    
    public void eliminarItemDeCompra( ItemDeCompra item){
        itemsDeCompra.remove(item);
    }
    
    public void vaciarCarritoDeCompra(){
        itemsDeCompra.clear();
    }
    
}
