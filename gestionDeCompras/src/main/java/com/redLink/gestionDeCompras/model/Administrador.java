
package com.redLink.gestionDeCompras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Administrador extends Rol{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idAdministrador;
    private String nombre;
    private String apellido;
    private String mail;
    private String documento;
    private String telefono;
    
    
    
}
