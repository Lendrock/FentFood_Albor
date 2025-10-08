package org.albor.fentfood.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.albor.fentfood.dominio.dto.GestorDto;
import org.albor.fentfood.dominio.dto.ModGestorDto;
import org.albor.fentfood.dominio.service.GestorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/gestores")
@Tag(name = "Gestores", description = "Operaciones CRUD para Gestores dentro de FentFood")
public class GestorController {

    private final GestorService gestorService;

    public GestorController(GestorService gestorService) {
        this.gestorService = gestorService;
    }

    @GetMapping
    public ResponseEntity<List<GestorDto>> obtenerGestores() {
        return ResponseEntity.ok(gestorService.obtenerTodo());
    }

    @GetMapping("{idGestor}")
    @Operation(
            summary = "Obtener un Gestor por su ID",
            description = "Retorna el gestor que coincide con el ID proporcionado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Gestor encontrado"),
                    @ApiResponse(responseCode = "404", description = "Gestor no encontrado", content = @Content)
            }
    )
    public ResponseEntity<GestorDto> buscarPorId(
            @Parameter(description = "ID del Gestor a recuperar", example = "1")
            @PathVariable Long idGestor) {
        return ResponseEntity.ok(gestorService.buscarPorIdGestor(idGestor));
    }

    @PostMapping
    public ResponseEntity<GestorDto> guardarGestor(
            @RequestBody @Valid GestorDto gestorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gestorService.guardarGestor(gestorDto));
    }

    @PutMapping("{idGestor}")
    public ResponseEntity<GestorDto> modificarGestor(
            @PathVariable Long idGestor,
            @RequestBody @Valid ModGestorDto modGestorDto) {
        return ResponseEntity.ok(gestorService.modificarGestor(idGestor, modGestorDto));
    }

    @DeleteMapping("{idGestor}")
    public ResponseEntity<Void> eliminarGestor(@PathVariable Long idGestor) {
        gestorService.eliminarGestor(idGestor);
        return ResponseEntity.ok().build();
    }
}
