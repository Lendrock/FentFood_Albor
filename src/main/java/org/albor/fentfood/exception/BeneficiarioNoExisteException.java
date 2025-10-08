package org.albor.fentfood.exception;

public class BeneficiarioNoExisteException extends RuntimeException {
    public BeneficiarioNoExisteException(Long id) {
        super("El beneficiario con el Id: " + id + " no existe en el sistema.");
    }
}