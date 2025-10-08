package org.albor.fentfood.persistence.crud;

import org.albor.fentfood.persistence.entity.DonadorEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudDonadorEntity extends CrudRepository<DonadorEntity, Long> {
    DonadorEntity findFirstByIdDonador(Long idDonador);
}