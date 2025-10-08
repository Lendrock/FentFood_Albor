package org.albor.fentfood.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.albor.fentfood.dominio.ProductUnit;
import org.albor.fentfood.dominio.ProductState;

import java.sql.Date;

public record ModProductoDto(
        @NotBlank(message = "El nombre del producto es obligatorio")
        String productName,
        @NotBlank(message = "La descripción es obligatoria")
        String description,
        @NotNull(message = "La unidad de medida es obligatoria")
        ProductUnit productUnit,
        Date expirationDate,
        ProductState productState
) {
}
