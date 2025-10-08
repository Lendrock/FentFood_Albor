package org.albor.fentfood.web.exception;

import org.albor.fentfood.exception.*;
import org.albor.fentfood.exception.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UsuarioYaExisteExeption.class)
    public ResponseEntity<Error> handleException(UsuarioYaExisteExeption ex) {
        Error error = new Error("usuario-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(UsuarioNoExisteException.class)
    public ResponseEntity<Error> handleException(UsuarioNoExisteException ex) {
        Error error = new Error("usuario-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ProductoYaExisteException.class)
    public ResponseEntity<Error> handleException(ProductoYaExisteException ex) {
        Error error = new Error("producto-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ProductoNoExisteException.class)
    public ResponseEntity<Error> handleException(ProductoNoExisteException ex) {
        Error error = new Error("producto-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        Error error = new Error("error-desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
