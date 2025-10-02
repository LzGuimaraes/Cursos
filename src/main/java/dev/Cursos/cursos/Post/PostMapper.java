package dev.Cursos.cursos.Post;

import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public PostModel map(PostDTO postDTO) {
        PostModel postModel = new PostModel();
        postModel.setTitulo(postDTO.getTitulo());
        postModel.setDescricao(postDTO.getDescricao());
        postModel.setCurso(postDTO.getCurso());
        return postModel;
    }
    public PostDTO map(PostModel postModel) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId_post(postModel.getId_post());
        postDTO.setTitulo(postModel.getTitulo());
        postDTO.setDescricao(postModel.getDescricao());
        postDTO.setCurso(postModel.getCurso());
        return postDTO;
    }
}
