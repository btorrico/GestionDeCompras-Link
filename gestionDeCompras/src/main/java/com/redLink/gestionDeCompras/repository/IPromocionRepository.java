
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.Promocion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPromocionRepository extends PagingAndSortingRepository<Promocion,Long> {
    
}
