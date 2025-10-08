package org.albor.fentfood.exception;

public class DonadorNoExisteException extends RuntimeException {
    public DonadorNoExisteException(Long id) {
        super("El donador con el Id: " + id + " no existe en el sistema.");
    }
}