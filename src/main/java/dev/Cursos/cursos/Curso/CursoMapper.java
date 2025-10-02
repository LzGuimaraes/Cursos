package dev.Cursos.cursos.Curso;

import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public CursoModel map(CursoDTO cursoDTO) {
        CursoModel cursoModel = new CursoModel();
        cursoModel.setNome(cursoDTO.getNome());
        cursoModel.setDescricao(cursoDTO.getDescricao());
        cursoModel.setEstado(cursoDTO.getEstado());
        cursoModel.setUsers(cursoDTO.getUser());
        cursoModel.setPosts(cursoDTO.getPost());
        return cursoModel;
    }

    public CursoDTO map(CursoModel cursoModel) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId_curso(cursoModel.getId_curso());
        cursoDTO.setNome(cursoModel.getNome());
        cursoDTO.setDescricao(cursoModel.getDescricao());
        cursoDTO.setEstado(cursoModel.getEstado());
        cursoDTO.setUser(cursoModel.getUsers());
        cursoDTO.setPost(cursoModel.getPosts());
        return cursoDTO;
    }
}
