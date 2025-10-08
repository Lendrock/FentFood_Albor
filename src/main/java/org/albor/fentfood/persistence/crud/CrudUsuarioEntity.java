package org.albor.fentfood.persistence.crud;

import org.albor.fentfood.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudUsuarioEntity extends CrudRepository<UsuarioEntity, Long > {
    UsuarioEntity findFirstByIdUsuario(Long idUsuario);
    Optional<UsuarioEntity> findByCorreo(String correo);
}
