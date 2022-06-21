
package com.redLink.gestionDeCompras.model;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Administrador extends Usuario{

//    private String nombre;
  //  private String apellido;
    //private String documento;
	
	
 //   @OneToMany(mappedBy = "administrador")
  //  private List<Cliente> clientes;  
   // private List<Vendedor> vendedores;
    //private List<Promocion> promociones;

    public Administrador() {
    }
/*    
    public void agregarVendedor(Vendedor nuevoVendedor){
        vendedores.add(nuevoVendedor);
    }
    
    public void eliminarVendedor(Vendedor vendedor){
        vendedores.remove(vendedor);
        
    }
    
    public void cargarPromocion(Promocion nuevaPromo){
        promociones.add(nuevaPromo);
    }
   
    public void eliminarPromocion(Promocion promocion){
        promociones.remove(promocion);
        
    }
    
  */

	public Administrador(Long id, String usuario, String contrasenia, TipoUsuario tipoUsuario) {
		super(id, usuario, contrasenia, tipoUsuario);
		// TODO Auto-generated constructor stub
	}

	public Administrador(Long id, String usuario, String contrasenia) {
		super(id, usuario, contrasenia);
		// TODO Auto-generated constructor stub
	}

	public Administrador(String usuario, String contrasenia, TipoUsuario tipoUsuario) {
		super(usuario, contrasenia, tipoUsuario);
		// TODO Auto-generated constructor stub
	}

	public Administrador(String usuario, String contrasenia) {
		super(usuario, contrasenia);
		// TODO Auto-generated constructor stub
	}
    

 
    
    


    

    

    
    
    
}
