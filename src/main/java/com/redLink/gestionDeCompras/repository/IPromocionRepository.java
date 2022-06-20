
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.Promocion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path ="promociones")
public interface IPromocionRepository extends PagingAndSortingRepository<Promocion,Long> {
    
}
