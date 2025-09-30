package dev.Cursos.cursos.Curso;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/curso")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    
    @GetMapping("/all")
    public List<CursoModel> getCurso() {
        return cursoService.getCurso();
    }

    @GetMapping("/all/{id}")
    public CursoModel getCursoById(@PathVariable Long id) {
        return cursoService.getCursoById(id);
    }

    @PostMapping("create")
    public String createCurso() {
        return "Curso created: ";
    }

    @PutMapping("alter/{id}")
    public String alterCurso() {
        return "Curso altered: ";
    }
    @DeleteMapping("delete/{id}")
    public String deleteCurso() {
        return "Curso deleted: ";
    }

}