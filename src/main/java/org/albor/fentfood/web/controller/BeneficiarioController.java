package org.albor.fentfood.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.albor.fentfood.dominio.dto.BeneficiarioDto;
import org.albor.fentfood.dominio.dto.ModBeneficiarioDto;
import org.albor.fentfood.dominio.service.BeneficiarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/beneficiarios")
@Tag(name = "Beneficiarios", description = "Operaciones CRUD para Beneficiarios dentro de FentFood Albor")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;

    public BeneficiarioController(BeneficiarioService beneficiarioService){
        this.beneficiarioService = beneficiarioService;
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioDto>> obtenerBeneficiarios(){
        return ResponseEntity.ok(this.beneficiarioService.obtenerTodo());
    }

    @GetMapping("{idBeneficiario}")
    @Operation(
            summary = "Obtener un beneficiario por su identificador",
            description = "Retorna el beneficiario que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Beneficiario encontrado"),
                    @ApiResponse(responseCode = "404", description = "Beneficiario no encontrado", content = @Content)
            }
    )
    public ResponseEntity<BeneficiarioDto> buscarPorId
            (@Parameter(description = "Identificar el beneficiario a recuperar", example = "3")
             @PathVariable Long idBeneficiario){
        return ResponseEntity.ok(this.beneficiarioService.buscarPorId(idBeneficiario));
    }

    @PostMapping
    public ResponseEntity<BeneficiarioDto> guardarBeneficiario
            (@RequestBody @Valid BeneficiarioDto beneficiarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.beneficiarioService.guardarBeneficiario(beneficiarioDto));
    }

    @PutMapping("{idBeneficiario}")
    public ResponseEntity<BeneficiarioDto> modificarBeneficiario
            (@PathVariable("idBeneficiario") Long idBeneficiario, @RequestBody @Valid ModBeneficiarioDto modBeneficiarioDto){
        return ResponseEntity.ok(this.beneficiarioService.modificarBeneficiario(idBeneficiario, modBeneficiarioDto));
    }

    @DeleteMapping("{idBeneficiario}")
    public ResponseEntity<Void> eliminarBeneficiario(@PathVariable Long idBeneficiario){
        this.beneficiarioService.eliminarBeneficiario(idBeneficiario);
        return ResponseEntity.ok().build();
    }
}