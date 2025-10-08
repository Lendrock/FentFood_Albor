package org.albor.fentfood.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.albor.fentfood.persistence.entity.UsuarioEntity.Rol;

public record ModUsuarioDto(
        Long idUsuario,
        @NotBlank(message = "El nombre es obligatorio.")
        String name,
        @NotBlank(message = "El correo es obligatorio.")
        String email,
        @NotNull(message = "El tipo es obligatorio.")
        Rol rol
) {
}
