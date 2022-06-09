
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.CarritoDeCompra;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoDeCompraRepository extends PagingAndSortingRepository<CarritoDeCompra,Long>{
    
}
