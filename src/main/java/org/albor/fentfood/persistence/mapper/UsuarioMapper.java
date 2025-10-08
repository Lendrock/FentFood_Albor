package org.albor.fentfood.persistence.mapper;

import org.albor.fentfood.dominio.dto.ModUsuarioDto;
import org.albor.fentfood.dominio.dto.RegistroUsuarioDto;
import org.albor.fentfood.dominio.dto.UsuarioDto;
import org.albor.fentfood.persistence.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "rol", target = "rol")
    UsuarioDto toDto(UsuarioEntity entity);

    List<UsuarioDto> toDto(Iterable<UsuarioEntity> entities);

    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "rol", target = "rol")
    @Mapping(source = "password", target = "psw", ignore = true)
    UsuarioEntity toEntity(RegistroUsuarioDto dto);

    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "rol", target = "rol")
    @Mapping(target = "psw", ignore = true)
    void modificarEntityFromDto(ModUsuarioDto mod, @MappingTarget UsuarioEntity entity);
}
