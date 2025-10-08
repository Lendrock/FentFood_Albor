package org.albor.fentfood.persistence.crud;

import jakarta.validation.constraints.NotNull;
import org.albor.fentfood.dominio.dto.UsuarioDto;
import org.albor.fentfood.persistence.entity.GestorEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudGestorEntity extends CrudRepository<GestorEntity, Long> {
    GestorEntity findFirstByNombreGestorAndApellidoGestor(String nombreGestor, String apellidoGestor);

    boolean existsById(@NotNull(message = "El usuario es obligatorio") UsuarioDto usuario);
}
