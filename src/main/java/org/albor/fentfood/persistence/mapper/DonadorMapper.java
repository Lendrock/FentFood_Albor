package org.albor.fentfood.persistence.mapper;

import org.albor.fentfood.dominio.dto.DonadorDto;
import org.albor.fentfood.dominio.dto.ModDonadorDto;
import org.albor.fentfood.persistence.entity.DonadorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DonadorMapper {

    @Mapping(source = "nombreDonador", target = "name")
    @Mapping(source = "apellidoDonador", target = "lastName")
    @Mapping(source = "telefono", target = "phone")
    @Mapping(source = "direccion", target = "address")
    DonadorDto toDto(DonadorEntity entity);

    List<DonadorDto> toDto(Iterable<DonadorEntity> entities);

    @Mapping(target = "idDonador", ignore = true)
    @Mapping(source = "name", target = "nombreDonador")
    @Mapping(source = "lastName", target = "apellidoDonador")
    @Mapping(source = "phone", target = "telefono")
    @Mapping(source = "address", target = "direccion")
    DonadorEntity toEntity(DonadorDto dto);

    @Mapping(target = "idDonador", ignore = true)
    @Mapping(source = "name", target = "nombreDonador")
    @Mapping(source = "lastName", target = "apellidoDonador")
    @Mapping(source = "phone", target = "telefono")
    @Mapping(source = "address", target = "direccion")
    void modificarEntityFromDto(ModDonadorDto dto, @MappingTarget DonadorEntity entity);
}