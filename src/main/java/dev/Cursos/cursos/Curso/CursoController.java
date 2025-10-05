package dev.Cursos.cursos.Curso;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Cursos.cursos.Curso.dto.CursoRequestDTO;
import dev.Cursos.cursos.Curso.dto.CursoResponseDTO;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/curso")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/all")
    public List<CursoResponseDTO> getCurso() {
        return cursoService.getCurso();
    }

    @GetMapping("/all/{id}")
    public CursoResponseDTO getCursoById(@PathVariable Long id) {
        return cursoService.getCursoById(id);
    }

    @PostMapping("create")
    public ResponseEntity<CursoResponseDTO> createCurso(@RequestBody @Valid CursoRequestDTO curso) {
        CursoResponseDTO createdCurso = cursoService.createCurso(curso);
        return new ResponseEntity<>(createdCurso,HttpStatus.CREATED);
    }

    @PutMapping("alter/{id}")
    public CursoResponseDTO alterCurso(@RequestBody Long id,@Valid @RequestBody CursoRequestDTO updatedCurso) {
        return cursoService.alterCurso(id, updatedCurso);
    }
    @DeleteMapping("delete/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }

}