package org.albor.fentfood.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import org.albor.fentfood.persistence.entity.UsuarioEntity.Rol;

public record UsuarioDto(
        Long idUsuario,
        @NotBlank(message = "El nombre es obligatorio.")
        String name,
        @NotBlank(message = "El correo es obligatorio.")
        String email,
        @NotBlank(message = "El tipo es obligatorio.")
        Rol rol

) {
}
