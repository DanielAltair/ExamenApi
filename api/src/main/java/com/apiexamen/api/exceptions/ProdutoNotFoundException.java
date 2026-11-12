package com.apiexamen.api.exceptions;

/**
 * Clase que se encarga de tener el método para lanzar la excepción de si un producto no existe.
 * @author Daniel
 * ProdutoNotFoundException
 */
public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(String mensaje){
        super(mensaje);
    }
    
}
