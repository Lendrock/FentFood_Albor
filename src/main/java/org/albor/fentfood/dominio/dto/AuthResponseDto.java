package org.albor.fentfood.dominio.dto;

public record AuthResponseDto(
        String token,
        Long idUsuario,
        String name,
        String email,
        String role
) { }