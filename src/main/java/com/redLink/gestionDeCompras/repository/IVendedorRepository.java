
package com.redLink.gestionDeCompras.repository;
import com.redLink.gestionDeCompras.model.Vendedor;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="vendedores")
public interface IVendedorRepository extends PagingAndSortingRepository<Vendedor,Long> {
   
	@Override
    Iterable<Vendedor> findAll();
	
    @RestResource(exported = false)
   Optional <Vendedor> findByNombre(String Nombre);
}
