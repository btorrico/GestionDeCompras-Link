
package com.redLink.gestionDeCompras.model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_Proveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;
    @ManyToMany(mappedBy="proveedores")
    private Collection<Producto> productos;

    public Proveedor(Long id_Proveedor, String nombre, String direccion, String telefono, String mail) {
        this.id_Proveedor = id_Proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
    }

    public Proveedor() {
        super();
    }
    
    
}
