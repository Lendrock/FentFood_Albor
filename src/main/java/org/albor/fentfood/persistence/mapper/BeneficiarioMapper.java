package org.albor.fentfood.persistence.mapper;

import org.albor.fentfood.dominio.dto.BeneficiarioDto;
import org.albor.fentfood.dominio.dto.ModBeneficiarioDto;
import org.albor.fentfood.persistence.entity.BeneficiarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeneficiarioMapper {

    // Entity -> DTO
    @Mapping(source = "nombreBeneficiario", target = "name")
    @Mapping(source = "apellidoBeneficiario", target = "lastName")
    @Mapping(source = "telefono", target = "phone")
    @Mapping(source = "direccion", target = "address")
    @Mapping(source = "necesidad", target = "need")
    BeneficiarioDto toDto(BeneficiarioEntity entity);

    List<BeneficiarioDto> toDto(Iterable<BeneficiarioEntity> entities);

    // DTO -> Entity (para guardar)
    @Mapping(target = "idBeneficiario", ignore = true)
    @Mapping(source = "name", target = "nombreBeneficiario")
    @Mapping(source = "lastName", target = "apellidoBeneficiario")
    @Mapping(source = "phone", target = "telefono")
    @Mapping(source = "address", target = "direccion")
    @Mapping(source = "need", target = "necesidad")
    BeneficiarioEntity toEntity(BeneficiarioDto dto);

    // ModDto -> Entity (para modificar)
    @Mapping(target = "idBeneficiario", ignore = true)
    @Mapping(source = "name", target = "nombreBeneficiario")
    @Mapping(source = "lastName", target = "apellidoBeneficiario")
    @Mapping(source = "phone", target = "telefono")
    @Mapping(source = "address", target = "direccion")
    @Mapping(source = "need", target = "necesidad")
    void modificarEntityFromDto(ModBeneficiarioDto dto, @MappingTarget BeneficiarioEntity entity);
}
