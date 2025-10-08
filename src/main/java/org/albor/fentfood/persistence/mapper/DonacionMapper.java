package org.albor.fentfood.persistence.mapper;

import org.albor.fentfood.dominio.dto.DonacionDto;
import org.albor.fentfood.dominio.dto.ModDonacionDto;
import org.albor.fentfood.persistence.entity.DonacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DonacionMapper {

    @Mapping(source = "fechaDonacion", target = "donationDate")
    @Mapping(source = "observaciones", target = "observations")
    DonacionDto toDto(DonacionEntity entity);

    List<DonacionDto> toDto(Iterable<DonacionEntity> entities);

    @Mapping(target = "idDonacion", ignore = true)
    @Mapping(source = "donationDate", target = "fechaDonacion")
    @Mapping(source = "observations", target = "observaciones")
    DonacionEntity toEntity(DonacionDto dto);

    @Mapping(target = "idDonacion", ignore = true)
    @Mapping(source = "donationDate", target = "fechaDonacion")
    @Mapping(source = "observations", target = "observaciones")
    void modificarEntityFromDto(ModDonacionDto dto, @MappingTarget DonacionEntity entity);
}