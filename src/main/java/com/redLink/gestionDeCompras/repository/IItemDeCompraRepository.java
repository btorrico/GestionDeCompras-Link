
package com.redLink.gestionDeCompras.repository;
import com.redLink.gestionDeCompras.model.ItemDeCompra;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "itemsDeCompra")
public interface IItemDeCompraRepository extends PagingAndSortingRepository<ItemDeCompra,Long> {
    
}
