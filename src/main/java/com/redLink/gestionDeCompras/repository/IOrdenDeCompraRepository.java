
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.OrdenDeCompra;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="ordenesDeCompra")
public interface IOrdenDeCompraRepository extends PagingAndSortingRepository<OrdenDeCompra,Long> {
    
}
