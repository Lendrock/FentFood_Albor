package org.albor.fentfood.persistence.mapper;

import org.albor.fentfood.dominio.dto.ProductoDto;
import org.albor.fentfood.dominio.dto.ModProductoDto;
import org.albor.fentfood.persistence.entity.ProductoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ProductUnitMapper.class, ProductStateMapper.class})
public interface ProductoMapper {

    @Mapping(source = "nombreProducto", target = "productName")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "unidadMedida", target = "productUnit", qualifiedByName = "generarProductUnit")
    @Mapping(source = "fechaVencimiento", target = "expirationDate")
    @Mapping(source = "estadoProducto", target = "productState", qualifiedByName = "generarProductState")
    ProductoDto toDto(ProductoEntity entity);

    @InheritInverseConfiguration
    @Mapping(source = "productUnit", target = "unidadMedida", qualifiedByName = "generarUnidadMedida")
    @Mapping(source = "productState", target = "estadoProducto", qualifiedByName = "generarEstadoProducto")
    ProductoEntity toEntity(ProductoDto dto);

    @Mapping(source = "productName", target = "nombreProducto")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "productUnit", target = "unidadMedida", qualifiedByName = "generarUnidadMedida")
    @Mapping(source = "expirationDate", target = "fechaVencimiento")
    @Mapping(source = "productState", target = "estadoProducto", qualifiedByName = "generarEstadoProducto")
    void modificarEntityFromDto(ModProductoDto mod, @MappingTarget ProductoEntity entity);
}
