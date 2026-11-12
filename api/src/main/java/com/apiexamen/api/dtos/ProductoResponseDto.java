package com.apiexamen.api.dtos;

import java.time.LocalDate;
/**
 * Clase que se encarga de gestionar la respuesta.
 * @author Daniel
 * ProductoResponseDto
 * @param idProducto
 * @param codigoSku
 * @param nombre
 * @param descripcion
 * @param precio
 * @param stock
 * @param fechaAlta
 */
public record ProductoResponseDto(
    Long idProducto,
    String codigoSku,
    String nombre, 
    String descripcion,
    double precio,
    Integer stock,
    LocalDate fechaAlta
) 

{}
