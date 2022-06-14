
package com.redLink.gestionDeCompras.model;
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
    private String mail;
    @OneToMany
    List<OrdenDeCompra> ordenDeCompra;
    @OneToMany
    private List<Producto> productos;

    public Vendedor(String nombre, String apellido, List<Proveedor> proveedores, String direccion, String documento, String telefono, String mail) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.proveedores = proveedores;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
        this.mail = mail;
    }

    public Vendedor(String nombre, String apellido, List<Proveedor> proveedores, String direccion, String documento, String telefono, String mail, String usuario, String contrasenia) {
        super(usuario, contrasenia);
        this.nombre = nombre;
        this.apellido = apellido;
        this.proveedores = proveedores;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
        this.mail = mail;
    }
    
    public Vendedor(Long idVendedor, String usuario, String contrasenia){
        super(idVendedor,usuario,contrasenia);
      
    }

    public Vendedor() {
        super();
    }

    public Vendedor(String nombre, String apellido, List<Proveedor> proveedores, String direccion, String documento, String telefono, String mail, List<OrdenDeCompra> ordenDeCompra, List<Producto> productos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.proveedores = proveedores;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
        this.mail = mail;
        this.ordenDeCompra = ordenDeCompra;
        this.productos = productos;
    }
    
    
  
    // Falta agregar metodos para agregar y eliminar vendedores
    
}
