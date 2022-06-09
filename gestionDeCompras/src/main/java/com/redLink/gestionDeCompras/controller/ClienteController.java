
package com.redLink.gestionDeCompras.controller;

import com.redLink.gestionDeCompras.model.Cliente;
import com.redLink.gestionDeCompras.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService clienteService;
    
    @PostMapping("/cliente/crear")
    public String saveCliente(@RequestBody Cliente cliente){ 
//Deberia devolver void pero devuele String para probar
        clienteService.saveCliente(cliente);
        return "El cliente se guardo satisfactoriamente";
    }
    
    @GetMapping("/cliente/{idcliente}")
    public Cliente findCliente(@PathVariable Long idCliente){
        return clienteService.findCliente(idCliente);
    }
    
    @DeleteMapping("cliente/eliminar/{idcliente}")
        public String deleteCliente(@PathVariable Long idCliente){
        clienteService.deleteCliente(idCliente);
        return "El cliente se eliminado satisfactoriamente";
    }
        
    @PutMapping("cliente/modificar/{idClienteOriginal}")
        public Cliente editCliente(@PathVariable Long idClienteOriginal,
                           @RequestParam(required = false, name ="idCliente") Long idClienteNuevo,
                           @RequestParam(required = false, name ="nombre")String nombreNuevo,
                           @RequestParam(required = false, name ="apellido") String apellidoNuevo,
                           @RequestParam(required = false, name ="direccion") String direccionNueva,
                           @RequestParam(required = false, name ="documento") String documentoNuevo,
                           @RequestParam(required = false, name ="telefono") String telefonoNuevo,
                           @RequestParam(required = false, name ="mail") String mailNuevo){
            
         clienteService.editCliente(idClienteOriginal, idClienteNuevo, nombreNuevo, apellidoNuevo, direccionNueva, documentoNuevo, telefonoNuevo, mailNuevo);

         Cliente clienteModificado= clienteService.findCliente(idClienteNuevo);
        
        return clienteModificado;
        }  

    @GetMapping("/clientes/traer")
        public List<Cliente> getClientes(){
            return clienteService.getClientes();
        }
}
   