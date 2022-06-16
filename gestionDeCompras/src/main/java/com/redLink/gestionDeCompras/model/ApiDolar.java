package com.redLink.gestionDeCompras.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
class ApiDolar {
    
    private String fecha;
    private String compra;
    private String venta;

    public ApiDolar(String fecha, String compra, String venta) {
        super();
        this.fecha = fecha;
        this.compra = compra;
        this.venta = venta;
    }


    public ApiDolar() {
        
    }
    
    
}
