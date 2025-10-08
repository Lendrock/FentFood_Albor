package org.albor.fentfood.persistence.crud;

import jakarta.validation.constraints.NotNull;
import org.albor.fentfood.persistence.entity.GestorEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudGestorEntity extends CrudRepository<GestorEntity, Long> {
    boolean existsByUsuario_IdUsuario(Long idUsuario);
}

