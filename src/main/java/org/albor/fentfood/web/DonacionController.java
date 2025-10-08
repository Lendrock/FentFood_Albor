package org.albor.fentfood.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.albor.fentfood.dominio.dto.DonacionDto;
import org.albor.fentfood.dominio.dto.ModDonacionDto;
import org.albor.fentfood.dominio.service.DonacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/donaciones")
@Tag(name = "Donaciones", description = "Operaciones CRUD para Donaciones dentro de FentFood Albor")
public class DonacionController {
    private final DonacionService donacionService;

    public DonacionController(DonacionService donacionService){
        this.donacionService = donacionService;
    }

    @GetMapping
    public ResponseEntity<List<DonacionDto>> obtenerDonaciones(){
        return ResponseEntity.ok(this.donacionService.obtenerTodo());
    }

    @GetMapping("{idDonacion}")
    @Operation(
            summary = "Obtener una donación por su identificador",
            description = "Retorna la donación que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Donación encontrada"),
                    @ApiResponse(responseCode = "404", description = "Donación no encontrada", content = @Content)
            }
    )
    public ResponseEntity<DonacionDto> buscarPorId
            (@Parameter(description = "Identificar la donación a recuperar", example = "3")
             @PathVariable Long idDonacion){
        return ResponseEntity.ok(this.donacionService.buscarPorId(idDonacion));
    }

    @PostMapping
    public ResponseEntity<DonacionDto> guardarDonacion
            (@RequestBody @Valid DonacionDto donacionDto){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.donacionService.guardarDonacion(donacionDto));
    }

    @PutMapping("{idDonacion}")
    public ResponseEntity<DonacionDto> modificarDonacion
            (@PathVariable("idDonacion") Long idDonacion, @RequestBody @Valid ModDonacionDto modDonacionDto){
        return ResponseEntity.ok(this.donacionService.modificarDonacion(idDonacion, modDonacionDto));
    }

    @DeleteMapping("{idDonacion}")
    public ResponseEntity<Void> eliminarDonacion(@PathVariable Long idDonacion){
        this.donacionService.eliminarDonacion(idDonacion);
        return ResponseEntity.ok().build();
    }
}