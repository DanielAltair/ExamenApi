package com.apiexamen.api.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que se encarga de tener la entidad con los atributos que se van a trabajar en la api y BD.
 * @author Daniel
 * Producto
 */
@Entity 
@Table (name = "productos")
public class Producto {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "productos")
    private Long idProducto;

    @Column (name = "codigo_sku", unique = true, nullable = false, length = 10)
    private String codigoSku;

    @Column (name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column (name = "descripcion", length = 255)
    private String descripcion;

    @Column (name = "precio", nullable = false)
    private double precio;

    @Column (name = "stock", nullable = false)
    private Integer stock;

    @Column (name = "fecha_alta", nullable = false)
    private LocalDate fechaAlta;

    public Producto() {
    }

    public Producto(Long idProducto, String codigoSku, String nombre, String descripcion, double precio, Integer stock,
            LocalDate fechaAlta) {
        this.idProducto = idProducto;
        this.codigoSku = codigoSku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fechaAlta = fechaAlta;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoSku() {
        return codigoSku;
    }

    public void setCodigoSku(String codigoSku) {
        this.codigoSku = codigoSku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

}
