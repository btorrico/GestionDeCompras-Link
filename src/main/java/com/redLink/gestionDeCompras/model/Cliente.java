
package com.redLink.gestionDeCompras.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente extends Usuario{

    private String nombre;
    private String apellido;
    private String direccion;
    private String documento;
    private String telefono;
    @OneToMany(mappedBy = "cliente")
    private List <OrdenDeCompra> comprasRealizadas;
  //  @ManyToOne
   // private Administrador administrador;


    public Cliente() {

    }
    


    public Cliente(String usuario,String contrasenia, String nombre, String apellido, String direccion, String documento, String telefono, List<OrdenDeCompra> comprasRealizadas) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
        this.comprasRealizadas= comprasRealizadas;
    }
        public Cliente( String usuario,String contrasenia,TipoUsuario rol,String nombre, String apellido, String direccion, String documento, String telefono) {
        super(usuario,contrasenia,rol);
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
    }
        public Cliente( String usuario,String contrasenia,String nombre, String apellido, String direccion, String documento, String telefono) {
        super(usuario,contrasenia);
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
    }
        
        public Cliente( String nombre, String apellido, String direccion, String documento, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
    }

    public Cliente(String nombre, String apellido, String direccion, String documento, String telefono, List<OrdenDeCompra> comprasRealizadas, Long id, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
        this.comprasRealizadas = comprasRealizadas;
    }
    

    public void comprar(OrdenDeCompra ordenNueva){
        comprasRealizadas.add(ordenNueva);
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



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public List<OrdenDeCompra> getComprasRealizadas() {
		return comprasRealizadas;
	}



	public void setComprasRealizadas(List<OrdenDeCompra> comprasRealizadas) {
		this.comprasRealizadas = comprasRealizadas;
	}
    

      
}
