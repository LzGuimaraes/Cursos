package dev.Cursos.cursos.Modulo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Cursos.cursos.Modulo.dto.ModuloRequestDTO;
import dev.Cursos.cursos.Modulo.dto.ModuloResponseDTO;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/modulo")
public class ModuloController {
    private ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ModuloResponseDTO>> getAllModulos(Pageable pageable) {
        Page<ModuloResponseDTO> modulo = moduloService.getAllModulos(pageable);
        return ResponseEntity.ok(modulo);
    }

    @GetMapping("/all/{id}")
    public ModuloResponseDTO getModuloById(@PathVariable Long id) {
        return moduloService.getModuloById(id);
    }
    @PostMapping("/create")
    public ResponseEntity<ModuloResponseDTO> create(@Valid @RequestBody ModuloRequestDTO dto) {
        ModuloResponseDTO created = moduloService.createModulo(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @DeleteMapping("delete/{id}")
    public void deleteModulo(@PathVariable Long id) {
        moduloService.deleteModulo(id);
    }
}
