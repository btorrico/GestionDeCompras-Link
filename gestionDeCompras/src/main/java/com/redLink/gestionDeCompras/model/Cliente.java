
package com.redLink.gestionDeCompras.model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente extends Rol{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String documento;
    private String telefono;
    private String mail;
    @OneToMany
    private Collection <OrdenDeCompra> comprasRealizadas;

    public Cliente() {
        super();
    }

    public Cliente(Long idCliente, String nombre, String apellido, String direccion, String documento, String telefono, String mail) {
        this.idCliente = idCliente;
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
