
package com.redLink.gestionDeCompras.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

import com.redLink.gestionDeCompras.excepciones.ResourceNotFoundException;
import com.redLink.gestionDeCompras.model.Promocion;
import com.redLink.gestionDeCompras.model.TipoDeDescuento;
import com.redLink.gestionDeCompras.model.TipoDePromocion;
import com.redLink.gestionDeCompras.model.Vendedor;
import com.redLink.gestionDeCompras.repository.IPromocionRepository;
import com.redLink.gestionDeCompras.repository.IVendedorRepository;

@RestController
public class PromocionControllerComplement {
    
	@Autowired
	private IPromocionRepository repoPromocion;

	//Lista promociones
	@Transactional
	@GetMapping("/promociones/lista")
	public Iterable<Promocion> listarTodasLasPromociones() {
		return repoPromocion.findAll();
	}
	

	//Alta Promocion
	@Transactional
	@PostMapping("/promociones/crear")
	public Promocion guardarPromocion(@RequestBody Promocion promocion) {
		return repoPromocion.save(promocion);
	}
    
	//Busqueda Promocion
	@Transactional
	@GetMapping("/promociones/{id}")
	public ResponseEntity<Promocion> obtenerPromocionPorId(@PathVariable Long id){
			Promocion promocion = repoPromocion.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe la promocion con el ID : " + id));
			return ResponseEntity.ok(promocion);
	}
	
	//Modificacion Promocion
	@Transactional
	@PutMapping("/promociones/modificar/{id}")
	public ResponseEntity<Promocion> actualizarPromocion(@PathVariable Long id,@RequestBody Promocion detallesPromocion){
		Promocion promocion = repoPromocion.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe la promocion con el ID : " + id));
		
		promocion.setTipoDePromocion(detallesPromocion.getTipoDePromocion());
		promocion.setTipoDeDescuento(detallesPromocion.getTipoDeDescuento());
		promocion.setFechaInicioPromo(detallesPromocion.getFechaInicioPromo());
		promocion.setFechaFinPromo(detallesPromocion.getFechaFinPromo());
		promocion.setCantidadDescontada(detallesPromocion.getCantidadDescontada());
		
		Promocion promocionActualizada = repoPromocion.save(promocion);
		return ResponseEntity.ok(promocionActualizada);
    }
	

	
	//Baja Promocion
	@DeleteMapping("/promociones/eliminar/{id}")
	@Transactional
	public ResponseEntity<Map<String,Boolean>> eliminarPromocion(@PathVariable Long id){
		Promocion promocion = repoPromocion.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe la promocion con el ID : " + id));
		
		repoPromocion.delete(promocion);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}


	

