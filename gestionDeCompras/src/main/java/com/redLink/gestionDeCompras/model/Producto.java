
package com.redLink.gestionDeCompras.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private String marca;
    private int cantStock;    
    private Boolean estaDisponible;
    private double precioPesos;
    private Cotizador cotizacion; // Precio USD
    
    @ManyToOne
    private Vendedor vendedor;
   
  @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "producto_x_proveedor", //Nombre atributo formado por ambas relaciones
            joinColumns = {@JoinColumn(name = "FK_idProducto")}, // Nombre de la FK de la primera tabla
            inverseJoinColumns = {@JoinColumn(name = "FK_idPRoveedor")} // Nombre de la FK de la segunda tabla
    )
    private Collection<Proveedor> proveedores;

    public Producto() {
    }

    public Producto(Long idProducto, String nombre, String descripcion, String marca, int cantStock, Boolean estaDisponible, double precioPesos, Cotizador cotizacion, Vendedor vendedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.cantStock = cantStock;
        this.estaDisponible = estaDisponible;
        this.precioPesos = precioPesos;
        this.cotizacion = cotizacion;
        this.vendedor = vendedor;
    }



    
    public void modificacionStock(int cantidadSolicitada){
        if(cantStock <= cantidadSolicitada){
           estaDisponible = false;
        }
        cantStock = cantStock - cantidadSolicitada;
    }
    
    
}
