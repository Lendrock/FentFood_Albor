package org.albor.fentfood.exception;

public class DonacionNoExisteException extends RuntimeException {
    public DonacionNoExisteException(Long id) {
        super("La donación con el Id: " + id + " no existe en el sistema.");
    }
}