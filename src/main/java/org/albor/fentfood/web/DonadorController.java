package org.albor.fentfood.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.albor.fentfood.dominio.dto.DonadorDto;
import org.albor.fentfood.dominio.dto.ModDonadorDto;
import org.albor.fentfood.dominio.service.DonadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/donadores")
@Tag(name = "Donadores", description = "Operaciones CRUD para Donadores dentro de FentFood Albor")
public class DonadorController {
    private final DonadorService donadorService;

    public DonadorController(DonadorService donadorService){
        this.donadorService = donadorService;
    }

    @GetMapping
    public ResponseEntity<List<DonadorDto>> obtenerDonadores(){
        return ResponseEntity.ok(this.donadorService.obtenerTodo());
    }

    @GetMapping("{idDonador}")
    @Operation(
            summary = "Obtener un donador por su identificador",
            description = "Retorna el donador que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Donador encontrado"),
                    @ApiResponse(responseCode = "404", description = "Donador no encontrado", content = @Content)
            }
    )
    public ResponseEntity<DonadorDto> buscarPorId
            (@Parameter(description = "Identificar el donador a recuperar", example = "3")
             @PathVariable Long idDonador){
        return ResponseEntity.ok(this.donadorService.buscarPorId(idDonador));
    }

    @PostMapping
    public ResponseEntity<DonadorDto> guardarDonador
            (@RequestBody @Valid DonadorDto donadorDto){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.donadorService.guardarDonador(donadorDto));
    }

    @PutMapping("{idDonador}")
    public ResponseEntity<DonadorDto> modificarDonador
            (@PathVariable("idDonador") Long idDonador, @RequestBody @Valid ModDonadorDto modDonadorDto){
        return ResponseEntity.ok(this.donadorService.modificarDonador(idDonador, modDonadorDto));
    }

    @DeleteMapping("{idDonador}")
    public ResponseEntity<Void> eliminarDonador(@PathVariable Long idDonador){
        this.donadorService.eliminarDonador(idDonador);
        return ResponseEntity.ok().build();
    }
}