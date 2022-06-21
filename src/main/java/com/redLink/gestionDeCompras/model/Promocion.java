
package com.redLink.gestionDeCompras.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Promocion {
    
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Id
    private Long idPromocion;
    private TipoDePromocion tipoDePromocion;
    private TipoDeDescuento tipoDeDescuento;
    private LocalDate fechaInicioPromo;
    private LocalDate fechaFinPromo; 
    private Float cantidadDescontada;

    public Promocion() {
    }


//TODO arreglar
	public abstract Double descuento(CarritoDeCompra carritoDeCompra);

	
	
	
	

	public Promocion(TipoDePromocion tipoDePromocion, TipoDeDescuento tipoDeDescuento, Float cantidadDescontada) {
		super();
		this.tipoDePromocion = tipoDePromocion;
		this.tipoDeDescuento = tipoDeDescuento;
		this.cantidadDescontada = cantidadDescontada;
	}


	public Promocion(TipoDePromocion tipoDePromocion, TipoDeDescuento tipoDeDescuento, LocalDate fechaInicioPromo,
			LocalDate fechaFinPromo, Float cantidadDescontada) {
		super();
		this.tipoDePromocion = tipoDePromocion;
		this.tipoDeDescuento = tipoDeDescuento;
		this.fechaInicioPromo = fechaInicioPromo;
		this.fechaFinPromo = fechaFinPromo;
		this.cantidadDescontada = cantidadDescontada;
	}


	public Promocion(Long idPromocion, TipoDePromocion tipoDePromocion, TipoDeDescuento tipoDeDescuento,
			LocalDate fechaInicioPromo, LocalDate fechaFinPromo, Float cantidadDescontada) {
		super();
		this.idPromocion = idPromocion;
		this.tipoDePromocion = tipoDePromocion;
		this.tipoDeDescuento = tipoDeDescuento;
		this.fechaInicioPromo = fechaInicioPromo;
		this.fechaFinPromo = fechaFinPromo;
		this.cantidadDescontada = cantidadDescontada;
	}


	public Long getIdPromocion() {
		return idPromocion;
	}


	public void setIdPromocion(Long idPromocion) {
		this.idPromocion = idPromocion;
	}


	public TipoDePromocion getTipoDePromocion() {
		return tipoDePromocion;
	}


	public void setTipoDePromocion(TipoDePromocion tipoDePromocion) {
		this.tipoDePromocion = tipoDePromocion;
	}


	public TipoDeDescuento getTipoDeDescuento() {
		return tipoDeDescuento;
	}


	public void setTipoDeDescuento(TipoDeDescuento tipoDeDescuento) {
		this.tipoDeDescuento = tipoDeDescuento;
	}


	public LocalDate getFechaInicioPromo() {
		return fechaInicioPromo;
	}


	public void setFechaInicioPromo(LocalDate fechaInicioPromo) {
		this.fechaInicioPromo = fechaInicioPromo;
	}


	public LocalDate getFechaFinPromo() {
		return fechaFinPromo;
	}


	public void setFechaFinPromo(LocalDate fechaFinPromo) {
		this.fechaFinPromo = fechaFinPromo;
	}


	public Float getCantidadDescontada() {
		return cantidadDescontada;
	}


	public void setCantidadDescontada(Float cantidadDescontada) {
		this.cantidadDescontada = cantidadDescontada;
	}
    
	
	
    
}
