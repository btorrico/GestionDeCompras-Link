
package com.redLink.gestionDeCompras.model;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter @Setter
@Entity
public class OrdenDeCompra {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idOrdenDeCompra;
  //  private String idFactura;
   @OneToMany(mappedBy = "ordenDeCompra")// Una orden de compra puede tener muchos items pero un item pertenece a una sola orden de compra
    private List<ItemDeCompra> itemsDeCompra;
    @CreationTimestamp //Permite persistir la fecha 
    private LocalDate fechaDeCompra;
    @Transient
    private List<Promocion> promocionesAplicadas;   
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Vendedor vendedor;

   // private MedioDePago medioDePago;
    // private Proveedor proveedor; Lo estoy viendo

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(Long idOrdenDeCompra, List<ItemDeCompra> itemsDeCompra, LocalDate fechaDeCompra, List<Promocion> promocionesAplicadas, Cliente cliente, Vendedor vendedor) {
        super();
        this.idOrdenDeCompra = idOrdenDeCompra;
        this.itemsDeCompra = itemsDeCompra;
        this.fechaDeCompra = fechaDeCompra;
        this.promocionesAplicadas = promocionesAplicadas;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }
    public OrdenDeCompra( List<ItemDeCompra> itemsDeCompra, LocalDate fechaDeCompra, List<Promocion> promocionesAplicadas, Cliente cliente, Vendedor vendedor) {
        super();
        this.itemsDeCompra = itemsDeCompra;
        this.fechaDeCompra = fechaDeCompra;
        this.promocionesAplicadas = promocionesAplicadas;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public OrdenDeCompra(Cliente cliente) {
        super();
        this.cliente = cliente;
    }

    public OrdenDeCompra(Cliente cliente, Vendedor vendedor) {
        super();
        this.cliente = cliente;
        this.vendedor = vendedor;
    }   
    
    public OptionalDouble precioPesos(){
        return itemsDeCompra.stream().mapToDouble(x->x.precioPesos()).average();
    }
       
    public OptionalDouble precioDolar(){
        return itemsDeCompra.stream().mapToDouble(x->x.precioDolar()).average();
    }
    

    
}
