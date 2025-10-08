package org.albor.fentfood.exception;

public class BeneficiarioYaExisteExeption extends RuntimeException {
    public BeneficiarioYaExisteExeption(Long id) {
        super("El beneficiario con el Id: " + id + " ya existe en el sistema.");
    }
}