package org.albor.fentfood.persistence;

import org.albor.fentfood.dominio.dto.DonacionDto;
import org.albor.fentfood.dominio.dto.ModDonacionDto;
import org.albor.fentfood.dominio.repository.DonacionRepository;
import org.albor.fentfood.exception.DonacionNoExisteException;
import org.albor.fentfood.exception.DonacionYaExisteExeption;
import org.albor.fentfood.persistence.crud.CrudDonacionEntity;
import org.albor.fentfood.persistence.entity.DonacionEntity;
import org.albor.fentfood.persistence.mapper.DonacionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonacionEntityRepository implements DonacionRepository {

    private final CrudDonacionEntity crudDonacionEntity;
    private final DonacionMapper donacionMapper;

    public DonacionEntityRepository(CrudDonacionEntity crudDonacionEntity, DonacionMapper donacionMapper) {
        this.crudDonacionEntity = crudDonacionEntity;
        this.donacionMapper = donacionMapper;
    }

    @Override
    public List<DonacionDto> obtenerTodo(){
        return this.donacionMapper.toDto(this.crudDonacionEntity.findAll());
    }

    @Override
    public DonacionDto buscarPorId(Long id){
        return this.donacionMapper.toDto(this.crudDonacionEntity.findById(id).orElse(null));
    }

    @Override
    public DonacionDto guardarDonacion(DonacionDto donacionDto){
        if (donacionDto.idDonacion() != null && this.crudDonacionEntity.findFirstByIdDonacion(donacionDto.idDonacion()) != null){
            throw new DonacionYaExisteExeption(donacionDto.idDonacion());
        }
        DonacionEntity donacion = new DonacionEntity();
        donacion = this.donacionMapper.toEntity(donacionDto);
        this.crudDonacionEntity.save(donacion);
        return this.donacionMapper.toDto(donacion);
    }

    @Override
    public DonacionDto modificarDonacion(Long id, ModDonacionDto modDonacionDto){
        DonacionEntity donacion = this.crudDonacionEntity.findById(id).orElse(null);
        if (donacion == null){
            throw new DonacionNoExisteException(id);
        }
        this.donacionMapper.modificarEntityFromDto(modDonacionDto, donacion);

        return this.donacionMapper.toDto(this.crudDonacionEntity.save(donacion));
    }

    @Override
    public void eliminarDonacion(Long id){
        if (!this.crudDonacionEntity.existsById(id)) {
            throw new DonacionNoExisteException(id);
        } else {
            this.crudDonacionEntity.deleteById(id);
        }
    }
}