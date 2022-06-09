
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="clientes")
public interface IClienteRepository extends PagingAndSortingRepository<Cliente,Long> {
    
}
