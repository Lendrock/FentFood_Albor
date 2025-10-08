package org.albor.fentfood.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModGestorDto(
        @NotNull(message = "El usuario es obligatorio")
        UsuarioDto usuario,
        @NotBlank(message = "El nombre del gestor es obligatorio")
        String firstName,
        @NotBlank(message = "El apellido del gestor es obligatorio")
        String lastName,
        @NotBlank(message = "El teléfono es obligatorio")
        String phone,
        @NotBlank(message = "La dirección es obligatoria")
        String address
) {}