// PostService.java
package dev.Cursos.cursos.Post;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Curso.CursoModel;
import dev.Cursos.cursos.Curso.CursoRepository;
import dev.Cursos.cursos.Post.dto.PostRequestDTO;
import dev.Cursos.cursos.Post.dto.PostResponseDTO;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CursoRepository cursoRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository, CursoRepository cursoRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.cursoRepository = cursoRepository;
        this.postMapper = postMapper;
    }

    public List<PostResponseDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::toResponse)
                .toList();
    }

    public PostResponseDTO getPostById(Long id) {
        return postRepository.findById(id)
                .map(postMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Post não encontrado."));
    }

    public PostResponseDTO createPost(PostRequestDTO dto) {
        CursoModel curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado."));

        PostModel post = postMapper.toModel(dto, curso);
        PostModel saved = postRepository.save(post);

        return postMapper.toResponse(saved);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
