
package com.redLink.gestionDeCompras.model;



public class CotizadorPrecioPesos implements Cotizador{

    private double precio;
    
    @Override
    public double calculoDePrecio() {
        return precio;
    }
    
}
