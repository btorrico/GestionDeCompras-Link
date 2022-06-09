
package com.redLink.gestionDeCompras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id 
    private Long id;
    private String usuario;
    private String contraseña;
    private Rol rol;

}
