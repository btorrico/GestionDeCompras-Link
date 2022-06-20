
package com.redLink.gestionDeCompras.model;

import java.util.List;
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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_Proveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;
    @ManyToMany(mappedBy="proveedores")
    private List<Vendedor> vendedores;

    public Proveedor(Long id_Proveedor, String nombre, String direccion, String telefono, String mail) {
        super();
        this.id_Proveedor = id_Proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
    }

    public Proveedor() {
        super();
    }

    public Proveedor(Long id_Proveedor, String nombre, String direccion, String telefono, String mail, List<Vendedor> vendedores) {
        this.id_Proveedor = id_Proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.vendedores = vendedores;
    }

    public Proveedor(String nombre, List<Vendedor> vendedores) {
        super();
        this.nombre = nombre;
        this.vendedores = vendedores;
    }

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
