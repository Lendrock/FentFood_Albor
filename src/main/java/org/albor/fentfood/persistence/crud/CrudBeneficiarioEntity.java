package org.albor.fentfood.persistence.crud;

import org.albor.fentfood.persistence.entity.BeneficiarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudBeneficiarioEntity extends CrudRepository<BeneficiarioEntity, Integer> {
    BeneficiarioEntity findFirstByIdBeneficiario(Integer idBeneficiario);
}
