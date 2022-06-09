
package com.redLink.gestionDeCompras.service;

import com.redLink.gestionDeCompras.model.Cliente;
import com.redLink.gestionDeCompras.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;

    
    @Override
    public void saveCliente(Cliente cliente) {
      clienteRepo.save(cliente);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente clienteBuscado = clienteRepo.findById(id).orElse(null); 
//TODO: falta cambiar ese null por otra excepcion!!!!!!!
        return clienteBuscado;
        
        /*    fun findById(duenioId: Long): Duenio {
        return repoDuenio.findById(duenioId)
            .orElseThrow { throw NotFoundException("No se encontrÃ³ el duenio indicado: $duenioId") }
    }*/
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }


    @Override
    public List<Cliente> getClientes() {
        
        List<Cliente> listaClientes = (List<Cliente>) clienteRepo.findAll();
        return listaClientes;     
    }


    @Override
    public void editCliente(Long idClienteOriginal, 
                            Long idClienteNuevo, 
                            String nombreNuevo, 
                            String apellidoNuevo, 
                            String direccionNueva, 
                           String documentoNuevo, 
                            String telefonoNuevo, 
                            String mailNuevo) {
       Cliente clienteOriginal = this.findCliente(idClienteOriginal);
       
       clienteOriginal.setIdCliente(idClienteNuevo);
       clienteOriginal.setNombre(nombreNuevo);
       clienteOriginal.setApellido(apellidoNuevo);
       clienteOriginal.setDireccion(direccionNueva);
       clienteOriginal.setDocumento(documentoNuevo);
       clienteOriginal.setTelefono(telefonoNuevo);
       clienteOriginal.setMail(mailNuevo);
       
       this.saveCliente(clienteOriginal);
    }

   

}


   
    



    

