package org.albor.fentfood.exception;

public class GestorNoExisteException extends RuntimeException {
    public GestorNoExisteException(Long id) {
        super("El Gestor con el Id: " + id + " no existe en el sistema.");
    }
}
