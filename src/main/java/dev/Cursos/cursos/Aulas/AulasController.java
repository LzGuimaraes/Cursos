package dev.Cursos.cursos.Aulas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Cursos.cursos.Aulas.dto.AulasRequestDTO;
import dev.Cursos.cursos.Aulas.dto.AulasResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

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
    public List<AulasResponseDTO> getAllAulas() {
        return aulasService.getAllAulas();
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
    public void deleteAulas(@PathVariable Long id) {
        aulasService.deleteAulas(id);
    }
    
    
}
