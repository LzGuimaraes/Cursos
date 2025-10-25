package dev.Cursos.cursos.Aulas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Cursos.cursos.Aulas.dto.AulasRequestDTO;
import dev.Cursos.cursos.Aulas.dto.AulasResponseDTO;
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
@RequestMapping("/aulas")
public class AulasController {
    private AulasService aulasService;

    public AulasController(AulasService aulasService) {
        this.aulasService = aulasService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<AulasResponseDTO>> getAllAulas(Pageable pageable) {
        Page<AulasResponseDTO> aulas = aulasService.getAllAulas(pageable);
        return ResponseEntity.ok(aulas);
    }

    
    @GetMapping("/{id}")
    public AulasResponseDTO getAulasById(@PathVariable Long id) {
        return aulasService.getAulasById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<AulasResponseDTO> create(@Valid @RequestBody AulasRequestDTO dto) {
        AulasResponseDTO created = aulasService.createAulas(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAulas(@PathVariable Long id) {
        aulasService.deleteAulas(id);
        return ResponseEntity.noContent().build(); 
    }
}
