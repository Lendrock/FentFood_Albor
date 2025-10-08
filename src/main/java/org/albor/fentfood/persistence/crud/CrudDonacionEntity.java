package org.albor.fentfood.persistence.crud;

import org.albor.fentfood.persistence.entity.DonacionEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudDonacionEntity extends CrudRepository<DonacionEntity, Long> {
    DonacionEntity findFirstByIdDonacion(Long idDonacion);
}