
package com.redLink.gestionDeCompras.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Promocion {
    
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long idPromocion;
    private TipoDePromocion tipoDePromocion;
    private TipoDeDescuento tipoDeDescuento;
    private LocalDate fechaInicioPromo;
    private LocalDate fechaFinPromo; // a ver dijo el ciego
    private double cantidadDescontada;
}
