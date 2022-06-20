
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.Administrador;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path= "administradores")
public interface IAdministradorRepository extends PagingAndSortingRepository<Administrador,Long>{
    

}
