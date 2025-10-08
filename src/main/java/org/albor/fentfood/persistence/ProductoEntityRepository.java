package org.albor.fentfood.persistence;

import org.albor.fentfood.dominio.dto.ProductoDto;
import org.albor.fentfood.dominio.dto.ModProductoDto;
import org.albor.fentfood.dominio.repository.ProductoRepository;
import org.albor.fentfood.exception.ProductoNoExisteException;
import org.albor.fentfood.exception.ProductoYaExisteException;
import org.albor.fentfood.persistence.crud.CrudProductoEntity;
import org.albor.fentfood.persistence.entity.ProductoEntity;
import org.albor.fentfood.persistence.mapper.ProductoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoEntityRepository implements ProductoRepository {

    private final CrudProductoEntity crudProductoEntity;
    private final ProductoMapper productoMapper;

    public ProductoEntityRepository(CrudProductoEntity crudProductoEntity, ProductoMapper productoMapper) {
        this.crudProductoEntity = crudProductoEntity;
        this.productoMapper = productoMapper;
    }

    @Override
    public List<ProductoDto> obtenerTodo() {
        return this.productoMapper.toDto(this.crudProductoEntity.findAll());
    }

    @Override
    public ProductoDto buscarPorIdProducto(Long idProducto) {
        return this.productoMapper.toDto(this.crudProductoEntity.findById(idProducto).orElse(null));
    }

    @Override
    public ProductoDto guardarProducto(ProductoDto productoDto) {
        if (this.crudProductoEntity.findFirstByNombreProducto(productoDto.productName()) != null) {
            throw new ProductoYaExisteException(productoDto.idProducto());
        } else {
            ProductoEntity producto = this.productoMapper.toEntity(productoDto);
            this.crudProductoEntity.save(producto);
            return this.productoMapper.toDto(producto);
        }
    }

    @Override
    public ProductoDto modificarProducto(Long idProducto, ModProductoDto modProductoDto) {
        ProductoEntity producto = this.crudProductoEntity.findById(idProducto).orElse(null);
        if (producto == null) {
            throw new ProductoNoExisteException(idProducto);
        } else {
            this.productoMapper.modificarEntityFromDto(modProductoDto, producto);
            return productoMapper.toDto(this.crudProductoEntity.save(producto));
        }
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        ProductoEntity producto = this.crudProductoEntity.findById(idProducto).orElse(null);
        if (producto == null) {
            throw new ProductoNoExisteException(idProducto);
        } else {
            this.crudProductoEntity.deleteById(idProducto);
        }
    }
}
