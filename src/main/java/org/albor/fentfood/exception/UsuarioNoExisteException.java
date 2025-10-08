package org.albor.fentfood.exception;

public class UsuarioNoExisteException extends RuntimeException {
    public UsuarioNoExisteException(Long id) {
        super("El usuario con el Id: " + id + " no  existe en el sistema.");
    }
}
