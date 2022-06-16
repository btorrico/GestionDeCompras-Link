
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.CarritoDeCompra;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="carritoDeCompras")
public interface ICarritoDeCompraRepository extends PagingAndSortingRepository<CarritoDeCompra,Long>{
    
}
