
package com.redLink.gestionDeCompras.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Vendedor extends Usuario{

    private String nombre;
    private String apellido;  
    @ManyToMany
    private List<Proveedor> proveedores;
    private String direccion;
    private String documento;
    private String telefono;
    @OneToMany(mappedBy= "vendedor")
    List<OrdenDeCompra> ordenDeCompra;
    @OneToMany(mappedBy= "vendedor")
    private List<Producto> productos;

    public Vendedor(String nombre, String apellido, List<Proveedor> proveedores, String direccion, String documento, String telefono) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.proveedores = proveedores;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
    }

    public Vendedor(String nombre, String apellido, List<Proveedor> proveedores, String direccion, String documento, String telefono, String usuario, String contrasenia) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.proveedores = proveedores;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
    }

    public Vendedor() {
        super();
    }

    public Vendedor(String nombre, String apellido, List<Proveedor> proveedores, String direccion, String documento, String telefono, List<OrdenDeCompra> ordenDeCompra, List<Producto> productos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.proveedores = proveedores;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
        this.ordenDeCompra = ordenDeCompra;
        this.productos = productos;
    }
    
    
  
    // Falta agregar metodos para agregar y eliminar vendedores
    
}
