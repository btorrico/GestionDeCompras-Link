
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
    @OneToMany(mappedBy= "vendedor")
    List<OrdenDeCompra> ordenDeCompra;
    @OneToMany(mappedBy= "vendedor")
    private List<Producto> productos;

    public Vendedor(String usuario,String contrasenia, TipoUsuario rol,String nombre, String apellido, List<Proveedor> proveedores, String direccion, String documento) {
        super(usuario,contrasenia,rol);
        this.nombre = nombre;
        this.apellido = apellido;
        this.proveedores = proveedores;
        this.direccion = direccion;
        this.documento = documento;
    }

    public Vendedor(String nombre, String apellido, List<Proveedor> proveedores, String direccion, String documento, String usuario, String contrasenia) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.proveedores = proveedores;
        this.direccion = direccion;
        this.documento = documento;
    }

    public Vendedor() {
        super();
    }

    public Vendedor(String nombre, String apellido, List<Proveedor> proveedores, String direccion, String documento, List<OrdenDeCompra> ordenDeCompra, List<Producto> productos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.proveedores = proveedores;
        this.direccion = direccion;
        this.documento = documento;
        this.ordenDeCompra = ordenDeCompra;
        this.productos = productos;
    }
    
    
  
    // Falta agregar metodos para agregar y eliminar vendedores
    
}
