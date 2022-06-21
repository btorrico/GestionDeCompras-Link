
package com.redLink.gestionDeCompras.controller;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redLink.gestionDeCompras.model.Vendedor;
import com.redLink.gestionDeCompras.repository.IVendedorRepository;
import com.redLink.gestionDeCompras.excepciones.ResourceNotFoundException;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class  VendedorControllerComplement {

	@Autowired
	private IVendedorRepository repoVendedor;

	//Lista vendedores
	@Transactional
	@GetMapping("/vendedores/lista")
	public Iterable<Vendedor> listarTodosLosVendedores() {
		return repoVendedor.findAll();
	}
	

	//Alta Vendedor
	@Transactional
	@PostMapping("/vendedores")
	public Vendedor guardarVendedor(@RequestBody Vendedor vendedor) {
		return repoVendedor.save(vendedor);
	}
    
	//Busqueda vendedor
	@Transactional
	@GetMapping("/vendedores/{id}")
	public ResponseEntity<Vendedor> obtenerVendedorPorId(@PathVariable Long id){
			Vendedor vendedor = repoVendedor.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el vendedor con el ID : " + id));
			return ResponseEntity.ok(vendedor);
	}
	
	//Modificacion Vendedor
	@Transactional
	@PutMapping("/vendedores/modificar/{id}")
	public ResponseEntity<Vendedor> actualizarVendedor(@PathVariable Long id,@RequestBody Vendedor detallesVendedor){
		Vendedor vendedor = repoVendedor.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el vendedor con el ID : " + id));
		
		vendedor.setNombre(detallesVendedor.getNombre());
		vendedor.setApellido(detallesVendedor.getApellido());
		vendedor.setDireccion(detallesVendedor.getDireccion());
		vendedor.setDocumento(detallesVendedor.getDocumento());
		
		Vendedor vendedorActualizado = repoVendedor.save(vendedor);
		return ResponseEntity.ok(vendedorActualizado);
    }
	
	//Baja vendedor
	@DeleteMapping("/vendedores/eliminar/{id}")
	@Transactional
	public ResponseEntity<Map<String,Boolean>> eliminarVendedor(@PathVariable Long id){
		Vendedor vendedor = repoVendedor.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
		
		repoVendedor.delete(vendedor);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}




