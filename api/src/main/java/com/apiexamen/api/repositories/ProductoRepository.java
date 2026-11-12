package com.apiexamen.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiexamen.api.entities.Producto;


/**
 * Interfaz que contiene los métodos necesarios de la UK.
 * @author Daniel
 * ProductoRepository
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    /**
     * Método para buscar un producto por el código Sku. 
     * @param codigoSku
     */
    Optional<Producto> findByCodigoSku(String codigoSku);
    /**
     * Método para ver si existe un producto por el código Sku.
     * @param codigoSku
     * @return
     */
    boolean existsByCodigoSku(String codigoSku);
    /**
     * Método para eliminar un producto por el código Sku.
     * @param codigoSku
     */
    void deleteByCodigoSku(String codigoSku);
}
