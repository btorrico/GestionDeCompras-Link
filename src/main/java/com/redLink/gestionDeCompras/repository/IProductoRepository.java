
package com.redLink.gestionDeCompras.repository;

import com.redLink.gestionDeCompras.model.Producto;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(path="productos")
public interface IProductoRepository extends PagingAndSortingRepository<Producto,Long> {
     @RestResource(exported = false)
    Optional <Producto> findByNombre(String Nombre);
    
    @Override
    Iterable<Producto> findAll();
    
    @Override
  //  @RestResource(exported = false) //permite ocultar el endpoint
         void deleteById(Long Id);

         /*
    @RestResource(exported = false)
     @Override
    void delete(Producto entity);
*/
}
