
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	
	public void eliminarProducto(Producto producto) {
		productos.remove(producto);
	}
	
	public void agregarProveedor(Proveedor proveedor) {
		proveedores.add(proveedor);
	}
	
	public void eliminarProveedor(Proveedor proveedor) {
		proveedores.remove(proveedor);
	}
  
    // Falta agregar metodos para agregar y eliminar vendedores
    
}
