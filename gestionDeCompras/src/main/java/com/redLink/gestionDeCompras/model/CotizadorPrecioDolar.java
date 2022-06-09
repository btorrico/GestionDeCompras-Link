
package com.redLink.gestionDeCompras.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class CotizadorPrecioDolar implements Cotizador{
    private double precio;

    @Override
    public double calculoDePrecio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    // Consumo de api con RestTemplate
    RestTemplate restTemplate= new RestTemplate();


    @GetMapping("/datos")
    public ApiDolar getApi(){
        String urlApi = "https://api-dolar-argentina.herokuapp.com/api/dolaroficial";
        ApiDolar precioDolar = restTemplate.getForObject(urlApi, ApiDolar.class);
        return precioDolar;
        
    }
    
}
