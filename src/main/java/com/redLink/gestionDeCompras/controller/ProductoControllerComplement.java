
package com.redLink.gestionDeCompras.controller;

import com.redLink.gestionDeCompras.excepciones.ResourceNotFoundException;
import com.redLink.gestionDeCompras.model.CategoriaDeProducto;
import com.redLink.gestionDeCompras.model.Cliente;
import com.redLink.gestionDeCompras.model.Producto;
import com.redLink.gestionDeCompras.repository.IProductoRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoControllerComplement {
    
    @Autowired
    IProductoRepository productoRepo;
    
    
    // Lista Productos
    @Transactional
    @RequestMapping(value = "productos/lista", method = RequestMethod.GET)
    public Iterable<Producto> listaProductos(){
        return productoRepo.findAll();
    }
    
    //Baja Producto
    
    @Transactional
    @RequestMapping(value = "/productos/eliminar/{idProducto}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProducto(@PathVariable("idProducto") Long idProducto){
        if(productoRepo.findById(idProducto) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el producto buscado");

        }
        productoRepo.deleteById(idProducto);
        return ResponseEntity.status(HttpStatus.OK).body("Producto eliminado con exito");
    }
    
    
    // Alta Producto
    @Transactional
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto) {
      productoRepo.save(producto);
              return "El producto se guardo satisfactoriamente";
    }

	//Modificacion Producto
	@Transactional
	@PutMapping("/productos/modificar/{id}")
	public ResponseEntity<Producto> actualizarCliente(@PathVariable Long id,@RequestBody Producto detallesProducto){
		Producto producto = productoRepo.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));
		
		producto.setNombre(detallesProducto.getNombre());
		producto.setDescripcion(detallesProducto.getDescripcion());
		producto.setCantStock(detallesProducto.getCantStock());
		producto.setCategoria(detallesProducto.getCategoria());
		producto.setPrecioPesos(detallesProducto.getPrecioPesos());
		producto.setPrecioDolar(detallesProducto.getPrecioDolar());
		
		Producto productoActualizado = productoRepo.save(producto);
		return ResponseEntity.ok(productoActualizado);
    }
	

    // Falta la modificacion
    
    
}
