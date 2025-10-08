package org.albor.fentfood.persistence.mapper;

import org.albor.fentfood.dominio.dto.GestorDto;
import org.albor.fentfood.dominio.dto.ModGestorDto;
import org.albor.fentfood.persistence.entity.GestorEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface GestorMapper {

    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "nombreGestor", target = "firstName")
    @Mapping(source = "apellidoGestor", target = "lastName")
    @Mapping(source = "telefono", target = "phone")
    @Mapping(source = "direccion", target = "address")
    GestorDto toDto(GestorEntity entity);

    @InheritInverseConfiguration
    GestorEntity toEntity(GestorDto dto);

    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "firstName", target = "nombreGestor")
    @Mapping(source = "lastName", target = "apellidoGestor")
    @Mapping(source = "phone", target = "telefono")
    @Mapping(source = "address", target = "direccion")
    void modificarEntityFromDto(ModGestorDto mod, @MappingTarget GestorEntity entity);

    List<GestorDto> toDto(Iterable<GestorEntity> all);
}