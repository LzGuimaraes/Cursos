package dev.Cursos.cursos.Curso;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/curso")
public class CursoController {

    @GetMapping("/all")
    public String getCurso() {
        return "List of Curso";
    }

    @GetMapping("/all/{id}")
    public String getCursoById() {
        return "Curso By Id: ";
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
