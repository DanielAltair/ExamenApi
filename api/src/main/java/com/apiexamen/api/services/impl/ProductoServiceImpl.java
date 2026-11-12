package com.apiexamen.api.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apiexamen.api.dtos.ProductoRequestDto;
import com.apiexamen.api.dtos.ProductoResponseDto;
import com.apiexamen.api.entities.Producto;
import com.apiexamen.api.exceptions.ProductoAlreadyExistsException;
import com.apiexamen.api.exceptions.ProdutoNotFoundException;
import com.apiexamen.api.repositories.ProductoRepository;
import com.apiexamen.api.services.ProductoService;
/**
 * Clase que hereda de ProductoServicio y contiene los metodos CRUD que se piden.
 * @author Daniel
 * ProductoServiceImpl
 */
@Service 
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional 
    public ProductoResponseDto actualizar(String codigoSku, ProductoRequestDto datos) {
        Producto producto = productoRepository.findByCodigoSku(codigoSku).orElseThrow(()-> new ProdutoNotFoundException("No existe ningún producto con el código: " + datos.codigoSku()));
        
        if(!producto.getCodigoSku().equalsIgnoreCase(datos.codigoSku()) && productoRepository.existsByCodigoSku(datos.codigoSku())){
            throw new ProductoAlreadyExistsException("Ya existe un producto con el código: " + codigoSku);
        }

        producto.setCodigoSku(datos.codigoSku());
        producto.setNombre(datos.codigoSku());
        producto.setDescripcion(datos.descripcion());
        producto.setPrecio(datos.precio());
        producto.setStock(datos.stock());
        producto.setFechaAlta(datos.fechaAlta());

        Producto actualizado = productoRepository.save(producto);

        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional (readOnly = true)
    public ProductoResponseDto buscarPorCodigoSku(String codigoSku) {
        Producto producto = productoRepository.findByCodigoSku(codigoSku).orElseThrow(()-> new ProdutoNotFoundException("No existe ningún producto con el código: " + codigoSku));

        return mapToResponseDto(producto);
    }

    @Override
    @Transactional (readOnly = true)
    public ProductoResponseDto buscarPorId(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new ProdutoNotFoundException("No existe ningún producto con el id: " + id));

        return mapToResponseDto(producto);
    }

    @Override
    @Transactional 
    public ProductoResponseDto crear(ProductoRequestDto datos) {
        if(productoRepository.existsByCodigoSku(datos.codigoSku())){
            throw new ProductoAlreadyExistsException("Ya existe un producto con el código Sku: " + datos.codigoSku());
        }

        Producto producto = new Producto();

        producto.setCodigoSku(datos.codigoSku());
        producto.setNombre(datos.nombre());
        producto.setDescripcion(datos.descripcion());
        producto.setPrecio(datos.precio());
        producto.setStock(datos.stock());
        producto.setFechaAlta(datos.fechaAlta());

        Producto guardado = productoRepository.save(producto);

        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional 
    public void eliminarPorCodigoSku(String codigoSku) {
        Producto producto = productoRepository.findByCodigoSku(codigoSku).orElseThrow(()-> new ProdutoNotFoundException("No existe ningún producto con el código: " + codigoSku));
        
        productoRepository.delete(producto);
    }

    @Override
    @Transactional (readOnly = true)
    public List<ProductoResponseDto> listar() {
        List<Producto> productos = productoRepository.findAll();

        return productos.stream()
        .map(this::mapToResponseDto)
        .toList();
    }

    private ProductoResponseDto mapToResponseDto(Producto producto){

        return new ProductoResponseDto(

            producto.getIdProducto(),
            producto.getCodigoSku(),
            producto.getNombre(),
            producto.getDescripcion(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getFechaAlta()

        );
    }
    
}
