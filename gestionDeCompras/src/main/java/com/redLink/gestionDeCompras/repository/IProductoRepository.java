
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="productos")
public interface IProductoRepository extends PagingAndSortingRepository<Producto,Long> {
    
}
