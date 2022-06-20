
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.Proveedor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="proveedores")
public interface IProveedorRepository extends PagingAndSortingRepository<Proveedor,Long> {
    
}
