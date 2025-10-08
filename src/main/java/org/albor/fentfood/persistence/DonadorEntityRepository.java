package org.albor.fentfood.persistence;

import org.albor.fentfood.dominio.dto.DonadorDto;
import org.albor.fentfood.dominio.dto.ModDonadorDto;
import org.albor.fentfood.dominio.repository.DonadorRepository;
import org.albor.fentfood.exception.DonadorNoExisteException;
import org.albor.fentfood.exception.DonadorYaExisteExeption;
import org.albor.fentfood.persistence.crud.CrudDonadorEntity;
import org.albor.fentfood.persistence.entity.DonadorEntity;
import org.albor.fentfood.persistence.mapper.DonadorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonadorEntityRepository implements DonadorRepository {

    private final CrudDonadorEntity crudDonadorEntity;
    private final DonadorMapper donadorMapper;

    public DonadorEntityRepository(CrudDonadorEntity crudDonadorEntity, DonadorMapper donadorMapper) {
        this.crudDonadorEntity = crudDonadorEntity;
        this.donadorMapper = donadorMapper;
    }

    @Override
    public List<DonadorDto> obtenerTodo(){
        return this.donadorMapper.toDto(this.crudDonadorEntity.findAll());
    }

    @Override
    public DonadorDto buscarPorId(Long id){
        return this.donadorMapper.toDto(this.crudDonadorEntity.findById(id).orElse(null));
    }

    @Override
    public DonadorDto guardarDonador(DonadorDto donadorDto){
        if (donadorDto.idDonador() != null && this.crudDonadorEntity.findFirstByIdDonador(donadorDto.idDonador()) != null){
            throw new DonadorYaExisteExeption(donadorDto.idDonador());
        }
        DonadorEntity donador = new DonadorEntity();
        donador = this.donadorMapper.toEntity(donadorDto);
        this.crudDonadorEntity.save(donador);
        return this.donadorMapper.toDto(donador);
    }

    @Override
    public DonadorDto modificarDonador(Long id, ModDonadorDto modDonadorDto){
        DonadorEntity donador = this.crudDonadorEntity.findById(id).orElse(null);
        if (donador == null){
            throw new DonadorNoExisteException(id);
        }
        this.donadorMapper.modificarEntityFromDto(modDonadorDto, donador);

        return this.donadorMapper.toDto(this.crudDonadorEntity.save(donador));
    }

    @Override
    public void eliminarDonador(Long id){
        if (!this.crudDonadorEntity.existsById(id)) {
            throw new DonadorNoExisteException(id);
        } else {
            this.crudDonadorEntity.deleteById(id);
        }
    }
}