package org.albor.fentfood.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(
        @NotBlank(message = "El correo es obligatorio.")
        String email,
        @NotBlank(message = "La contraseña es obligatoria.")
        String password
) { }