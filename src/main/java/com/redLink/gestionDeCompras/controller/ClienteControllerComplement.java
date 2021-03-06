

package com.redLink.gestionDeCompras.controller;

import com.redLink.gestionDeCompras.excepciones.ResourceNotFoundException;
import com.redLink.gestionDeCompras.model.Cliente;
import com.redLink.gestionDeCompras.repository.IClienteRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteControllerComplement {
    @Autowired
    IClienteRepository clienteRepo;
    
    // Lista Clientes
    @Transactional
    @GetMapping("/clientes/traer")
    public Iterable<Cliente> getClientes(){
    	return clienteRepo.findAll();
    }
    
    
    //ALTA Cliente
    @Transactional
    @PostMapping("/cliente/crear")
    public String saveCliente(@RequestBody Cliente cliente){ 
//Deberia devolver void pero devuele String para probar
        clienteRepo.save(cliente);
        return "El cliente se guardo satisfactoriamente";
    }
    
    //Encontrar por Id
    @Transactional
    @GetMapping("/cliente/{idcliente}")
    public Optional<Cliente> findCliente(@PathVariable Long id){
        return clienteRepo.findById(id);
    }
    
    // BAJA Cliente
    @Transactional
    @DeleteMapping("cliente/eliminar/{idcliente}")
        public String deleteCliente(@PathVariable Long idCliente){
        clienteRepo.deleteById(idCliente);
        return "El cliente se eliminado satisfactoriamente";
    }

    
	//Modificacion Cliente
	@Transactional
	@PutMapping("/clientes/modificar/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id,@RequestBody Cliente detallesCliente){
		Cliente cliente = clienteRepo.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
		//Falta agregar usuario y contrasenia
		cliente.setNombre(detallesCliente.getNombre());
		cliente.setApellido(detallesCliente.getApellido());
		cliente.setDireccion(detallesCliente.getDireccion());
		cliente.setDocumento(detallesCliente.getDocumento());
		cliente.setTelefono(detallesCliente.getTelefono());
		
		Cliente clienteActualizado = clienteRepo.save(cliente);
		return ResponseEntity.ok(clienteActualizado);
    }
	
    
  /*
        // Modificacion Cliente
        @Transactional
    @PutMapping("cliente/modificar/{idClienteOriginal}")
        public Cliente editCliente(@PathVariable Long idClienteOriginal,
                           @RequestParam(required = false, name ="idCliente") Long idClienteNuevo,
                           @RequestParam(required = false, name ="nombre")String nombreNuevo,
                           @RequestParam(required = false, name ="apellido") String apellidoNuevo,
                           @RequestParam(required = false, name ="direccion") String direccionNueva,
                           @RequestParam(required = false, name ="documento") String documentoNuevo,
                           @RequestParam(required = false, name ="telefono") String telefonoNuevo,
                           @RequestParam(required = false, name ="mail") String mailNuevo){
            
         clienteRepo.editCliente(idClienteOriginal, idClienteNuevo, nombreNuevo, apellidoNuevo, direccionNueva, documentoNuevo, telefonoNuevo, mailNuevo);

         Cliente clienteModificado= clienteRepo.findCliente(idClienteNuevo);
        
        return clienteModificado;
        }  

*/
}
   