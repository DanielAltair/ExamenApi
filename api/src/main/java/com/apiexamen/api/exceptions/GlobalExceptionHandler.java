package com.apiexamen.api.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase que se encarga de gestionar las excepciones personalizadas.
 * @author Daniel
 * GlobalExceptionHandler
 */
@RestControllerAdvice 
public class GlobalExceptionHandler{
    
    @ExceptionHandler (ProductoAlreadyExistsException.class)
    public ProblemDetail comprobarConflictoDeDatosProducto(ProductoAlreadyExistsException ex){
        ProblemDetail problema = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());

        problema.setTitle("Conflicto de datos");
        problema.setProperty("timestamp", Instant.now());

        return problema;
    }

    @ExceptionHandler (ProdutoNotFoundException.class)
    public ProblemDetail comprobarExistenciaDelProducto(ProdutoNotFoundException ex){
        ProblemDetail problema = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());

        problema.setTitle("No existe ningún producto");
        problema.setProperty("timestamp", Instant.now());

        return problema;
    }
}
