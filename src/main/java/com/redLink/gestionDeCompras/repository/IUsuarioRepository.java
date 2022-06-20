package com.redLink.gestionDeCompras.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.redLink.gestionDeCompras.model.Usuario;

@RepositoryRestResource(path="usuarios")
public interface IUsuarioRepository extends PagingAndSortingRepository<Usuario,Long> {
    
}