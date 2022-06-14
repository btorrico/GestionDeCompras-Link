
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
    private String mail;
    @OneToMany(mappedBy = "cliente")
    private List <OrdenDeCompra> comprasRealizadas;

    public Cliente() {
        super();
    }
    
        public Cliente(String usuario,String contrasenia, String nombre, String apellido, String direccion, String documento, String telefono, String mail) {
        super(usuario,contrasenia);
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
        this.mail = mail;
    }

    public Cliente(Long idCliente,String usuario,String contrasenia, String nombre, String apellido, String direccion, String documento, String telefono, String mail, List<OrdenDeCompra> comprasRealizadas) {
        super(idCliente,usuario,contrasenia);
      
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
        this.mail = mail;
        this.comprasRealizadas= comprasRealizadas;
    }
        public Cliente( String nombre, String apellido, String direccion, String documento, String telefono, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.telefono = telefono;
        this.mail = mail;
    }
    
    
    public void comprar(OrdenDeCompra ordenNueva){
        comprasRealizadas.add(ordenNueva);
    }



    

    
    
    
    
}
