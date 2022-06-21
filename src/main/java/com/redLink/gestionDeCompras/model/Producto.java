
package com.redLink.gestionDeCompras.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

import com.redLink.gestionDeCompras.excepciones.SinStockException;

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private int cantStock; 
    @Enumerated(EnumType.STRING)
    CategoriaDeProducto categoria;
// private String imagen;
  //  private Boolean estaDisponible;
    private Float precioPesos;
  //  private Cotizador cotizacion; // Precio USD
    private Float precioDolar;
    @ManyToOne
    private Proveedor proveedor;
    
    @ManyToOne
    private Vendedor vendedor;
 
   /* Lo unico que falta arreglar
    @Value("${gestionDeCompras.apiDolares}")
    String apiDolares;
*/
    
    
    /*
  @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "producto_x_proveedor", //Nombre atributo formado por ambas relaciones
            joinColumns = {@JoinColumn(name = "FK_idProducto")}, // Nombre de la FK de la primera tabla
            inverseJoinColumns = {@JoinColumn(name = "FK_idPRoveedor")} // Nombre de la FK de la segunda tabla
    )
    private Collection<Proveedor> proveedores;
*/
    public Producto() {
    }

    public Producto(Long idProducto, String nombre, String descripcion,int cantStock, CategoriaDeProducto categoria, Float precioPesos, Float precioDolar, Vendedor vendedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantStock = cantStock;
        this.categoria = categoria;
        this.precioPesos = precioPesos;
        this.precioDolar = precioDolar;
        this.vendedor = vendedor;
    }

    public Producto(String nombre, String descripcion,int cantStock, Float precioPesos, Float precioDolar, Vendedor vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantStock = cantStock;
        this.precioPesos = precioPesos;
        this.precioDolar = precioDolar;
        this.vendedor = vendedor;
    }

    public Producto(String nombre, String descripcion,int cantStock, CategoriaDeProducto categoria, Float precioPesos, Float precioDolar, Vendedor vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantStock = cantStock;
        this.categoria = categoria;
        this.precioPesos = precioPesos;
        this.precioDolar = precioDolar;
        this.vendedor = vendedor;
    }

    
    
    public Producto(String nombre, String descripcion, int cantStock, CategoriaDeProducto categoria, Float precioPesos,
			Proveedor proveedor, Vendedor vendedor) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantStock = cantStock;
		this.categoria = categoria;
		this.precioPesos = precioPesos;
		this.proveedor = proveedor;
		this.vendedor = vendedor;
	}

	private Float valorActualDolar(){
            // Consumo de api con RestTemplate
    RestTemplate restTemplate= new RestTemplate();
        String urlApi = "https://api-dolar-argentina.herokuapp.com/api/dolaroficial";
        ApiDolar precioDolar = restTemplate.getForObject(urlApi, ApiDolar.class);
        return Float.parseFloat(precioDolar.getCompra());
        
    }
    
    public Float getPrecioPesos(){
        if(this.precioPesos == null){
            return this.precioDolar * this.valorActualDolar();
        }
        return this.precioPesos;
    }
    

    public Float getPrecioDolar(){
        if(this.precioDolar == null){
            return this.precioPesos / this.valorActualDolar();
        }
        return this.precioDolar;
    }
    
    //falta ver bien como se hace la cotizacion

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

    public void adquirirProducto(int cantidadAdquirida) throws SinStockException{
    	if(cantStock >= cantidadAdquirida) {
    		this.setCantStock(this.getCantStock() - cantidadAdquirida);
    	}else {
    		throw new SinStockException("No hay stock suficiente del producto", nombre);
    	}
    }
    
   
    
	public int getCantStock() {
		return cantStock;
	}

	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}

	public void renovarStock(int cantidadAAgregar) {
		cantStock = this.getCantStock() + cantidadAAgregar;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		return true;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CategoriaDeProducto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDeProducto categoria) {
		this.categoria = categoria;
	}

	public void setPrecioPesos(Float precioPesos) {
		this.precioPesos = precioPesos;
	}

	public void setPrecioDolar(Float precioDolar) {
		this.precioDolar = precioDolar;
	}




    /*
    public void modificacionStock(int cantidadSolicitada){
        if(cantStock <= cantidadSolicitada){
           estaDisponible = false;
        }
        cantStock = cantStock - cantidadSolicitada;
    }
    */
    
}
