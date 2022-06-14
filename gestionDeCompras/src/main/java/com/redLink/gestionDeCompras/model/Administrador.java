
package com.redLink.gestionDeCompras.model;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Administrador extends Usuario{
    
    public Administrador(Long id, String usuario, String contrasenia, int activo){
        super(id, usuario,contrasenia,activo);
    }
    
    public Administrador() {
    }
    
    public Administrador( String usuario, String contrasenia){
        super( usuario,contrasenia);
    }
    

    
    
    
}
