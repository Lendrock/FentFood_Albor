package org.albor.fentfood.dominio.service;

import org.albor.fentfood.dominio.dto.ProductoDto;
import org.albor.fentfood.dominio.dto.ModProductoDto;
import org.albor.fentfood.dominio.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<ProductoDto> obtenerTodo(){
        return this.productoRepository.obtenerTodo();
    }

    public ProductoDto buscarPorIdProducto(Long idProducto){
        return this.productoRepository.buscarPorIdProducto(idProducto);
    }

    public ProductoDto guardarProducto(ProductoDto productoDto){
        return this.productoRepository.guardarProducto(productoDto);
    }

    public ProductoDto modificarProducto(Long idProducto, ModProductoDto modProductoDto){
        return this.productoRepository.modificarProducto(idProducto, modProductoDto);
    }

    public void eliminarProducto(Long idProducto){
        this.productoRepository.eliminarProducto(idProducto);
    }
}
