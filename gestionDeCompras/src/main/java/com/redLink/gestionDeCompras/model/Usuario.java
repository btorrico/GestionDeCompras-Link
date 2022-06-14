
package com.redLink.gestionDeCompras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario {
    
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id 
    private Long id;
    private String usuario;
    private String contrasenia;
    private int activo;

    public Usuario(Long id, String usuario, String contrasenia, int activo) {
        super();
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.activo = activo;
    }

    public Usuario() {
    }

        public Usuario( String usuario, String contrasenia) {
        super();
        this.usuario = usuario;
        this.contrasenia = contrasenia;

    }

    

        public Usuario( Long id,String usuario, String contrasenia) {
        super();
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;

    }
}
