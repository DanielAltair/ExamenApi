package com.apiexamen.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiexamen.api.dtos.ProductoRequestDto;
import com.apiexamen.api.dtos.ProductoResponseDto;
import com.apiexamen.api.services.ProductoService;
/**
 * Clase que contiene los endpoints.
 * @author Daniel
 * ProductoController
 */
@RestController 
@RequestMapping ("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping 
    ResponseEntity <List<ProductoResponseDto>> listar(){
        List<ProductoResponseDto> listado = productoService.listar();

        return ResponseEntity.ok(listado);
    }

    @GetMapping ("/{id}")
    ResponseEntity <ProductoResponseDto> listarPorId(@PathVariable Long id){
        ProductoResponseDto listado = productoService.buscarPorId(id);

        return ResponseEntity.ok(listado);
    }

    @GetMapping ("/codigoSku/{codigoSku}")
    ResponseEntity <ProductoResponseDto> listarPorCodigoSku(@PathVariable String codigoSku){
        ProductoResponseDto listado = productoService.buscarPorCodigoSku(codigoSku);

        return ResponseEntity.ok(listado);
    }

    @PostMapping 
    ResponseEntity <ProductoResponseDto> crear(@RequestBody ProductoRequestDto datos){
        ProductoResponseDto creado = productoService.crear(datos);

        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping ("/codigoSku/{codigoSku}")
    ResponseEntity <ProductoResponseDto> actualizar(@PathVariable String codigoSku, @RequestBody ProductoRequestDto datos){
        ProductoResponseDto actualizado = productoService.actualizar(codigoSku, datos);

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping ("/codigoSku/{codigoSku}")
    ResponseEntity<Void> eliminarPorCodigoSku(@PathVariable String codigoSku){
        productoService.eliminarPorCodigoSku(codigoSku);

        return ResponseEntity.noContent().build();
    }
    
}
