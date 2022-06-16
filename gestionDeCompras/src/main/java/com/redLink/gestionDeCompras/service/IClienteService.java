
package com.redLink.gestionDeCompras.service;

import com.redLink.gestionDeCompras.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    //Alta de cliente
    public void saveCliente(Cliente cliente);
    
    //Lectura de un cliente en particular por su id
    public Cliente findCliente(Long id);
    
    //Baja de cliente por su id
    public void deleteCliente(Long id);
    
    //Modificacion cliente
    
    /*CORREGIR
    public void editCliente(Long idClienteOriginal,
                            Long idClienteNuevo,
                            String nombreNuevo,
                            String apellidoNuevo,
                            String direccionNueva,
                           String documentoNuevo,
                            String telefonoNuevo,
                            String mailNuevo);
    */
    //Lista de clientes
    public List<Cliente> getClientes();


}
