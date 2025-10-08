package org.albor.fentfood.persistence.mapper;

import org.albor.fentfood.dominio.dto.DetalleDonacionDto;
import org.albor.fentfood.dominio.dto.ModDetalleDonacionDto;
import org.albor.fentfood.persistence.entity.DetalleDonacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleDonacionMapper {

    @Mapping(source = "cantidad", target = "quantity")
    DetalleDonacionDto toDto(DetalleDonacionEntity entity);

    List<DetalleDonacionDto> toDto(Iterable<DetalleDonacionEntity> entities);

    @Mapping(target = "idDetalleDonacion", ignore = true)
    @Mapping(source = "quantity", target = "cantidad")
    DetalleDonacionEntity toEntity(DetalleDonacionDto dto);

    @Mapping(target = "idDetalleDonacion", ignore = true)
    @Mapping(source = "quantity", target = "cantidad")
    void modificarEntityFromDto(ModDetalleDonacionDto dto, @MappingTarget DetalleDonacionEntity entity);
}