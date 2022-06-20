package com.redLink.gestionDeCompras;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.redLink.gestionDeCompras.repository.IClienteRepository;
import com.redLink.gestionDeCompras.repository.IItemDeCompraRepository;
import com.redLink.gestionDeCompras.repository.IOrdenDeCompraRepository;
import com.redLink.gestionDeCompras.repository.IProductoRepository;
import com.redLink.gestionDeCompras.repository.IProveedorRepository;
import com.redLink.gestionDeCompras.repository.IUsuarioRepository;
import com.redLink.gestionDeCompras.repository.IVendedorRepository;

public class InitData implements CommandLineRunner {

	@Autowired
	RepositoryRestConfiguration config;
	
	@Autowired
	IClienteRepository repoCliente;
	
	@Autowired
	IVendedorRepository repoVendedor;
	
	@Autowired
	IProveedorRepository repoProveedor;
	
	@Autowired
	IItemDeCompraRepository repoItemDeCompra;
	
	@Autowired
	IUsuarioRepository repoUsuario;
	
	@Autowired
	IOrdenDeCompraRepository repoOrdenDeCompra;
	
	@Autowired
	IProductoRepository repoProducto;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
	
	
}
