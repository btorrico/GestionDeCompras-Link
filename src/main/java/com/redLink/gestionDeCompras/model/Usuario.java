
package com.redLink.gestionDeCompras.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    
 //  @GeneratedValue(generator = "UUID") // numerico unico
  // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
   //@Column(name = "id", updatable= false, nullable = false, unique = true, columnDefinition = "BINARY(16)")
    
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    // private UUID  id;
    private Long id;
    //String id;
    private String usuario;
    private String contrasenia;
    private TipoUsuario tipoUsuario;



    public Usuario() {
    }

        public Usuario( String usuario, String contrasenia) {
        super();
        this.usuario = usuario;
        this.contrasenia = contrasenia;

    }

    
}
