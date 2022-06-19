
package com.redLink.gestionDeCompras.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter @Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {
    
   @GeneratedValue(generator = "UUID") // numerico unico
   @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
   @Column(name = "id", updatable= false, nullable = false, unique = true, columnDefinition = "BINARY(16)")
    
    @Id
   // @GeneratedValue(strategy= GenerationType.TABLE)
     private UUID  id;
    //String id;
    private String usuario;
    private String contrasenia;
    private int activo;

    public Usuario( String usuario, String contrasenia, int activo) {
        super();

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

    
}
