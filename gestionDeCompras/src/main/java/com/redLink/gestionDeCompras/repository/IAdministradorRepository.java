
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.Administrador;
import org.springframework.data.repository.PagingAndSortingRepository;

//@Repository
public interface IAdministradorRepository extends PagingAndSortingRepository<Administrador,Long>{
    
}
