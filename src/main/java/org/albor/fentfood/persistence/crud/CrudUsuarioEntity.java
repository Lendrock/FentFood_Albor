package org.albor.fentfood.persistence.crud;

import org.albor.fentfood.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudUsuarioEntity extends CrudRepository<UsuarioEntity, Long> {
    UsuarioEntity findFirstById(Long id);
}
