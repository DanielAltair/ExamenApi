package com.apiexamen.api.dtos;

import java.time.LocalDate;
/**
 * Clase que se encarga de gestionar la entrada de datos.
 * ProductoRequestDto
 * @param codigoSku
 * @param nombre
 * @param descripcion
 * @param precio
 * @param stock
 * @param fechaAlta
 */
public record ProductoRequestDto(

    
    String codigoSku,
    String nombre, 
    String descripcion,
    double precio,
    Integer stock,
    LocalDate fechaAlta
) 

{}
