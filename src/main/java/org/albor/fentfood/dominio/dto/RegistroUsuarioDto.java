package org.albor.fentfood.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.albor.fentfood.persistence.entity.UsuarioEntity.Rol;

public record RegistroUsuarioDto(
        Long idUsuario,
        @NotBlank(message = "El nombre es obligatorio.")
        String name,
        @NotBlank(message = "El correo es obligatorio.")
        String email,
        @NotBlank(message = "La contraseña es obligatoria.")
        @Size(min = 4, message = "La contraseña debe tener como minimo 6 caracteres.")
        String password,
        @NotNull(message = "El tipo es obligatorio.")
        Rol rol
) {
}
