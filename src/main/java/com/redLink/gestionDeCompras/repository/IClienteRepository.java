
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.Cliente;
import com.redLink.gestionDeCompras.model.Producto;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="clientes")
public interface IClienteRepository extends PagingAndSortingRepository<Cliente,Long> {
  
    @RestResource(exported = false)
    Optional <Cliente> findByNombre(String Nombre);
    
    @Override
    @RestResource(exported = false)
    Iterable<Cliente> findAll();
    
    @Override
    @RestResource(exported = false)
         void deleteById(Long Id);
/*      
    //Alta de cliente
    public void saveCliente(Cliente cliente);
    
    //Lectura de un cliente en particular por su id
    public Cliente findCliente(Long id);
    
    //Baja de cliente por su id
    public void deleteCliente(Long id);
    
    //Modificacion cliente

    public void editCliente(Long idClienteOriginal,
                            Long idClienteNuevo,
                            String nombreNuevo,
                            String apellidoNuevo,
                            String direccionNueva,
                           String documentoNuevo,
                            String telefonoNuevo,
                            String mailNuevo);
 */

   
}
