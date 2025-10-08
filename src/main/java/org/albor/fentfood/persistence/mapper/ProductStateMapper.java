package org.albor.fentfood.persistence.mapper;

import org.albor.fentfood.dominio.ProductState;
import org.mapstruct.Named;

public class ProductStateMapper {

    @Named("generarProductState")
    public static ProductState generarProductState(String estadoProducto) {
        if (estadoProducto == null) return null;

        return switch (estadoProducto.toUpperCase()) {
            case "VIGENTE" -> ProductState.ACTIVE;
            case "VENCIDO" -> ProductState.EXPIRED;
            case "ENTREGADO" -> ProductState.DELIVERED;
            case "DESCARTADO" -> ProductState.DISCARDED;
            case "ALMACENADO" -> ProductState.STORED;
            default -> null;
        };
    }

    @Named("generarEstadoProducto")
    public static String generarEstadoProducto(ProductState productState) {
        if (productState == null) return null;

        return switch (productState) {
            case ACTIVE -> "VIGENTE";
            case EXPIRED -> "VENCIDO";
            case DELIVERED -> "ENTREGADO";
            case DISCARDED -> "DESCARTADO";
            case STORED -> "ALMACENADO";
        };
    }
}
