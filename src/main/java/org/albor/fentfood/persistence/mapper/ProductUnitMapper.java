package org.albor.fentfood.persistence.mapper;

import org.albor.fentfood.dominio.ProductUnit;
import org.mapstruct.Named;

public class ProductUnitMapper {

    @Named("generarProductUnit")
    public static ProductUnit generarProductUnit(String unidadMedida) {
        if (unidadMedida == null) return null;

        return switch (unidadMedida.toUpperCase()) {
            case "UNIDAD" -> ProductUnit.UNIT;
            case "PIEZA" -> ProductUnit.PIECE;
            case "PAQUETE" -> ProductUnit.PACKAGE;
            case "BOLSA" -> ProductUnit.BAG;
            case "KG" -> ProductUnit.KG;
            case "G" -> ProductUnit.G;
            case "L" -> ProductUnit.L;
            case "ML" -> ProductUnit.ML;
            case "DOCENA" -> ProductUnit.DOZEN;
            case "CAJA" -> ProductUnit.BOX;
            default -> null;
        };
    }

    @Named("generarUnidadMedida")
    public static String generarUnidadMedida(ProductUnit productUnit) {
        if (productUnit == null) return null;

        return switch (productUnit) {
            case UNIT -> "UNIDAD";
            case PIECE -> "PIEZA";
            case PACKAGE -> "PAQUETE";
            case BAG -> "BOLSA";
            case KG -> "KG";
            case G -> "G";
            case L -> "L";
            case ML -> "ML";
            case DOZEN -> "DOCENA";
            case BOX -> "CAJA";
        };
    }
}
