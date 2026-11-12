package com.apiexamen.api.exceptions;
/**
 * Clase que se encarga de tener el método para lanzar la excepción de si un producto ya existe.
 * @author Daniel
 * ProductoAlreadyExistsException
 */
public class ProductoAlreadyExistsException extends RuntimeException{

    public ProductoAlreadyExistsException(String mensaje){
        super(mensaje);
    }
    
}
