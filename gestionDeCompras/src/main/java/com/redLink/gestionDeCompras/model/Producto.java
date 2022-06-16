
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

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private String marca;
    private int cantStock; 
    @Enumerated(EnumType.STRING)
    CategoriaDeProducto categoria;
// private String imagen;
  //  private Boolean estaDisponible;
    private Float precioPesos;
  //  private Cotizador cotizacion; // Precio USD
    private Float precioDolar;
    
    @ManyToOne
    private Vendedor vendedor;
 
   /*  Lo unico que falta arreglar
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

    public Producto(Long idProducto, String nombre, String descripcion, String marca, int cantStock, CategoriaDeProducto categoria, Float precioPesos, Float precioDolar, Vendedor vendedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.cantStock = cantStock;
        this.categoria = categoria;
        this.precioPesos = precioPesos;
        this.precioDolar = precioDolar;
        this.vendedor = vendedor;
    }

    public Producto(String nombre, String descripcion, String marca, int cantStock, Float precioPesos, Float precioDolar, Vendedor vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.cantStock = cantStock;
        this.precioPesos = precioPesos;
        this.precioDolar = precioDolar;
        this.vendedor = vendedor;
    }

    public Producto(String nombre, String descripcion, String marca, int cantStock, CategoriaDeProducto categoria, Float precioPesos, Float precioDolar, Vendedor vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.cantStock = cantStock;
        this.categoria = categoria;
        this.precioPesos = precioPesos;
        this.precioDolar = precioDolar;
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



    /*
    public void modificacionStock(int cantidadSolicitada){
        if(cantStock <= cantidadSolicitada){
           estaDisponible = false;
        }
        cantStock = cantStock - cantidadSolicitada;
    }
    */
    
}
