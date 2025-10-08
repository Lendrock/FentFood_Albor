package org.albor.fentfood.persistence.crud;

import org.albor.fentfood.persistence.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudProductoEntity extends CrudRepository<ProductoEntity, Long> {
    ProductoEntity findFirstByNombreProducto(String nombreProducto);
}
