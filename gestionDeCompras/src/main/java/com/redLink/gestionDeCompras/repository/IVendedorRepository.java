
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.Vendedor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="vendedores")
public interface IVendedorRepository extends PagingAndSortingRepository<Vendedor,Long> {
    
}
