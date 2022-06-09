
package com.redLink.gestionDeCompras.model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Vendedor {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idVendedor;
    private String nombre;
    private String apellido;  
    @ManyToOne
    private Proveedor proveedor;
    private String direccion;
    private String documento;
    private String telefono;
    private String mail;
    @OneToMany
    private Collection<Producto> productos;

    public Vendedor(Long idVendedor, String nombre, String apellido, Proveedor proveedor, String direccion, String documento, String telefono, String mail) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.proveedor = proveedor;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
        this.mail = mail;
    }

    public Vendedor() {
        super();
    }
  
    
    
}
