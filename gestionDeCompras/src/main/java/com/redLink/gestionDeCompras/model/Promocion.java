
package com.redLink.gestionDeCompras.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Promocion {
    
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Id
    private Long idPromocion;
    private TipoDePromocion tipoDePromocion;
    private TipoDeDescuento tipoDeDescuento;
    private LocalDate fechaInicioPromo;
    private LocalDate fechaFinPromo; // a ver dijo el ciego
    private Float cantidadDescontada;

    public Promocion() {
    }
    
    
}
