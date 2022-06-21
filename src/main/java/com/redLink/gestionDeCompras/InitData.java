package com.redLink.gestionDeCompras;

import java.util.List;

import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.redLink.gestionDeCompras.model.Administrador;
import com.redLink.gestionDeCompras.model.CategoriaDeProducto;
import com.redLink.gestionDeCompras.model.Cliente;
import com.redLink.gestionDeCompras.model.ItemDeCompra;
import com.redLink.gestionDeCompras.model.OrdenDeCompra;
import com.redLink.gestionDeCompras.model.Producto;
import com.redLink.gestionDeCompras.model.Proveedor;
import com.redLink.gestionDeCompras.model.TipoUsuario;
import com.redLink.gestionDeCompras.model.Usuario;
import com.redLink.gestionDeCompras.model.Vendedor;
import com.redLink.gestionDeCompras.repository.IAdministradorRepository;
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
	
	@Autowired
	IAdministradorRepository repoAdministrador;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		config.exposeIdsFor(Producto.class, Usuario.class, Vendedor.class,Administrador.class, Cliente.class,ItemDeCompra.class,OrdenDeCompra.class,Proveedor.class);
		
		//Carga de promociones

		if (repoCliente.count() == 0) {

			List<Cliente> clientesIniciales = List.of(cliente1, cliente2, cliente3,cliente4);

			clientesIniciales.stream().forEach(x -> {
				repoCliente.save(x);
			});
		}

		if (repoProveedor.count() == 0) {
			List<Proveedor> proveedoresIniciales = List.of(proveedor1, proveedor2, proveedor3,proveedor4);

			proveedoresIniciales.stream().forEach(x -> {
				repoProveedor.save(x);
			});
		}
		
		if (repoVendedor.count() == 0) {
			List<Vendedor> vendedoresIniciales = List.of(vendedor1, vendedor2, vendedor3,vendedor4);

			vendedoresIniciales.stream().forEach(x -> {
				repoVendedor.save(x);
			});
		}
		

		if (repoAdministrador.count() == 0) {
			repoAdministrador.save(admin);
		}

		if (repoProducto.count() == 0) {
			List<Producto> productosIniciales = List.of(producto1,producto2,producto3,producto4,producto5,producto6,producto7,producto8,producto9,producto10,producto11,producto12,producto13,producto14,producto15,producto16);

			productosIniciales.stream().forEach(x -> {
				repoProducto.save(x);
			});
		}

		if (repoOrdenDeCompra.count() == 0) {
			List<OrdenDeCompra> ocsIniciales = List.of(ordenDeCompra1,ordenDeCompra2,ordenDeCompra3,ordenDeCompra4);

			ocsIniciales.stream().forEach(x -> {
				repoOrdenDeCompra.save(x);
			});

		}

		if (repoItemDeCompra.count() == 0) {
			List<ItemDeCompra> iocsIniciales = List.of(itemDeCompra1,itemDeCompra2,itemDeCompra3,itemDeCompra4,itemDeCompra5,itemDeCompra6,itemDeCompra7);

			iocsIniciales.stream().forEach(x -> {
				repoItemDeCompra.save(x);
			});
		}


	}
	
	// Administrador administrador = new Administrador(usuario,contrasenia);
	Administrador admin = new Administrador("admin","admin",TipoUsuario.ADMINISTRADOR);
	
	//Cliente cliente = new Cliente(usuario,contrasenia,rol,nombre,apellido,direccion,documento,telefono);

	Cliente cliente1 = new Cliente("mariatc","1234",TipoUsuario.CLIENTE,"Maria", "Lopez","Maipu 123","3245532","113456356");
	Cliente cliente2 = new Cliente("juantm","5678",TipoUsuario.CLIENTE,"Juan", "Maita","Las Heras 345","8965646","116578940");
	Cliente cliente3 = new Cliente("brandontm","9101",TipoUsuario.CLIENTE,"Brandon", "Maita","Las Heras 345","865368","11975479");
	Cliente cliente4 = new Cliente("charot","1121",TipoUsuario.CLIENTE,"Charo", "Torres","Esmeralda 567","4324567","11567654");

	
	//Proveedor proveedor = new Proveedor(usuario,contrasenia,nombre,direccion,telefono,mail);

	Proveedor proveedor1 = new Proveedor("notcoprov","contranot","Notco","Saenz Peña 123","11245743","notco@gmail.com");
	Proveedor proveedor2 = new Proveedor("cabralesprov","cabralescon","Cabrales","Maipu 689","11467942", "cabrales@gmail.com");
	Proveedor proveedor3 = new Proveedor("almadreprov","almadrecon","Almadre","Hipolito Irigoyen 454","112324457","almadre@gmail.com");
	Proveedor proveedor4 = new Proveedor("dbvsasprov","dbvsascon","Dbvsas","Montaña 456","11457853","dbvsas@gmail.com");
	
	
	//Vendedor vendedor = new Vendedor(usuario,contrasenia,rol,nombre,apellido, proveedores, direccion,documento);
    
	Vendedor vendedor1 = new Vendedor("manuel27","manu123",TipoUsuario.VENDEDOR,"Manuel","Baigorria",List.of(proveedor3,proveedor2),"Suipacha 342","23456422");
    Vendedor vendedor2 = new Vendedor("lauriS","laura27",TipoUsuario.VENDEDOR,"Laura","Sejas",List.of(proveedor1,proveedor4),"Esmeralda 123","285948372");
    Vendedor vendedor3 = new Vendedor("carolaAr","carol4",TipoUsuario.VENDEDOR,"Carola","Copa",List.of(proveedor2,proveedor3),"Lima 234","2134355");
    Vendedor vendedor4 = new Vendedor("pedroAlt","pedrito5",TipoUsuario.VENDEDOR,"Pedro","Altamira",List.of(proveedor2,proveedor1),"Singapur 56","43565643");

	// Producto producto = new Producto(nombre,descripcion,cantStock, categoria, precioPesos,proveedor,vendedor);
    
    Producto producto1 = new Producto("Frutillas x 300gr - KARINAT","Frutas enteras 100% natural, sin endulzantes ni conservantes supercongeladas.",30,CategoriaDeProducto.CONGELADOS,(float)538.74,proveedor1,vendedor4);
    Producto producto2 = new Producto("Not Ice Cream Chocolate Chips x 330gr 100% Vegan - NOTCO","Not Ice Cream Chocolate & Chips es un helado vegano libre de glúten a base de vegetales.",60,CategoriaDeProducto.CONGELADOS,(float)728.84,proveedor2,vendedor3);
    Producto producto3 = new Producto("Not Burger Premium Flow Pack x 160gr (2u) SIN TACC - NOTCO","Not Burger de NotCo 100% Vegan ",15,CategoriaDeProducto.CONGELADOS,(float)433.77,proveedor1,vendedor1);
    Producto producto4 = new Producto("Bites Frambuesas Bañadas en Chocolate x 120gr - KARINAT","Fruta 100% natural entera bañada en chocolate blanco y chocolate negro.",1,CategoriaDeProducto.CONGELADOS,(float)498.69,proveedor2,vendedor1);
    Producto producto5 = new Producto("Pochoclos Orgánicos con Azúcar x 80 gr - BAMBOO","Pochoclos elaborados con maíz sin transgénicos",12,CategoriaDeProducto.ALMACEN,(float)203.69,proveedor3,vendedor4);
    Producto producto6 = new Producto("Karnevil Party x 320gr (4u) - FELICES LAS VACAS","Medallon a Base de Arveja. Más rica en proteínas",4,CategoriaDeProducto.CONGELADOS,(float)618.16,proveedor2,vendedor4);
    Producto producto7 = new Producto("Dulce de Leche de Almendras x 250gr - FELICES LAS VACAS","DULCE DE ALMENDRAS",2,CategoriaDeProducto.ALMACEN,(float)277.46,proveedor1,vendedor3);
    Producto producto8 = new Producto("Leche de Coco Original x 1 Lt S/TACC - DALE COCO","Leche de Coco - Dale Coco",5,CategoriaDeProducto.BEBIDAS,(float)366.46,proveedor2,vendedor2);
    Producto producto9 = new Producto("Galletita Cacao y Miel Orgánica x 170gr - CACHAFAZ","Galletas Orgánicas,100% harina integral orgánica. Cacao y Miel",23,CategoriaDeProducto.SNACKS,(float)193.99,proveedor4,vendedor1);
    Producto producto10 = new Producto("Pizzas de Masa Integral Fugazzeta x 290g - BEEPURE","",25,CategoriaDeProducto.ALMACEN,(float)578.11,proveedor3,vendedor1);
    Producto producto11 = new Producto("Pizzas de Masa Integral Fugazzeta x 290g - BEEPURE","Nuggets de Quinoa y Garbanzos",40,CategoriaDeProducto.ALMACEN,(float)489.90,proveedor4,vendedor2);
    Producto producto12 = new Producto("Jugo Detox Remolacha, Naranja y Zanahoria x 1 Lts - CUARTO CRECIENTE","JUGO DETOX REMOLACHA",10,CategoriaDeProducto.BEBIDAS,(float)205.50 ,proveedor3,vendedor3);
    Producto producto13 = new Producto("Not Chicken Nuggets x 400gr - NOTCO","Not Chicken Nuggets rebozado a base de proteina de arveja, garbanzo y haba congelado",3,CategoriaDeProducto.CONGELADOS,(float)773.56,proveedor3,vendedor1);
    Producto producto14 = new Producto("Galletitas de Almendras y Harina de Garbanzos x 180 gr Sin TACC - LOVVIT","Producto libre de gluten. No contiene lácteos, colorantes ni conservantes",2,CategoriaDeProducto.SNACKS,(float)285.62,proveedor2,vendedor4);
    Producto producto15 = new Producto("Burganas Hamburguesa de Berenjena + Pimentón Ahumado 4U x 460gr - TIENDA VEGGIE","HAMBURGUESAS VEGETALES",6,CategoriaDeProducto.CONGELADOS,(float)352.89,proveedor1,vendedor3);
    Producto producto16 = new Producto("Empanadas Chinas de Carne y Acelga x 276 gr - FU BAO","Mas conocidas como Gyozas, elaboradas con carne bovina y acelga.",8,CategoriaDeProducto.ALMACEN,(float)462.04,proveedor3,vendedor2);
    
    //OrdenDeCompra ordenDeCompra1 = new OdenDeCompra(cliente,vendedor);
    OrdenDeCompra ordenDeCompra1 = new OrdenDeCompra(cliente1,vendedor2);
    OrdenDeCompra ordenDeCompra2 = new OrdenDeCompra(cliente2,vendedor2);
    OrdenDeCompra ordenDeCompra3 = new OrdenDeCompra(cliente3,vendedor1);
    OrdenDeCompra ordenDeCompra4 = new OrdenDeCompra(cliente4,vendedor4);

    
    //ItemDeCompra itemDeCompra1 = new ItemDeCompra(producto,cantidadDeProducto,OrdenDeCompra);
    
    ItemDeCompra itemDeCompra1 = new ItemDeCompra(producto1,2,ordenDeCompra2);
    ItemDeCompra itemDeCompra2 = new ItemDeCompra(producto3,1,ordenDeCompra2);
    ItemDeCompra itemDeCompra3 = new ItemDeCompra(producto1,3,ordenDeCompra1);
    ItemDeCompra itemDeCompra4 = new ItemDeCompra(producto5,2,ordenDeCompra3);
    ItemDeCompra itemDeCompra5 = new ItemDeCompra(producto8,4,ordenDeCompra3);
    ItemDeCompra itemDeCompra6 = new ItemDeCompra(producto6,1,ordenDeCompra2);
    ItemDeCompra itemDeCompra7 = new ItemDeCompra(producto9,7,ordenDeCompra4);
    
	
}
