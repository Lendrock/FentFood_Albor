package org.albor.fentfood.dominio.repository;

import org.albor.fentfood.dominio.dto.ProductoDto;
import org.albor.fentfood.dominio.dto.ModProductoDto;

import java.util.List;

public interface ProductoRepository {
    List<ProductoDto> obtenerTodo();
    ProductoDto buscarPorIdProducto(Long idProducto);
    ProductoDto guardarProducto(ProductoDto productoDto);
    ProductoDto modificarProducto(Long idProducto, ModProductoDto modProductoDto);
    void eliminarProducto(Long idProducto);
}
