package org.albor.fentfood.persistence.crud;

import org.albor.fentfood.persistence.entity.GestorEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudGestorEntity extends CrudRepository<GestorEntity, Long> {
    GestorEntity findFirstByNombreGestorAndApellidoGestor(String nombreGestor, String apellidoGestor);
}
