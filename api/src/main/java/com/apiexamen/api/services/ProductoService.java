package com.apiexamen.api.services;

import java.util.List;

import com.apiexamen.api.dtos.ProductoRequestDto;
import com.apiexamen.api.dtos.ProductoResponseDto;
/**
 * Interfaz que contiene los métodos del CRUD indicado.
 * @author Daniel
 * ProductoService
 */
public interface ProductoService {
    /**
     * Método para crear un producto.
     * @param datos
     * @return
     */
    ProductoResponseDto crear(ProductoRequestDto datos);
    /**
     * Método para listar los productos.
     * @return
     */
    List<ProductoResponseDto> listar();
    /**
     * Método para actualizar un producto por el código Sku.
     * @param codigoSku
     * @param datos
     * @return
     */
    ProductoResponseDto actualizar(String codigoSku, ProductoRequestDto datos);
    /**
     * Método para buscar un producto por el id.
     * @param id
     * @return
     */
    ProductoResponseDto buscarPorId(Long id);
    /**
     * Método para buscar un producto por el código Sku.
     * @param codigoSku
     * @return
     */
    ProductoResponseDto buscarPorCodigoSku(String codigoSku);

    /**
     * Método para eliminar un producto por el código Sku.
     * @param codigoSku
     */
    void eliminarPorCodigoSku(String codigoSku);
}
