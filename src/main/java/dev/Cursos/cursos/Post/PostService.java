package dev.Cursos.cursos.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Curso.CursoModel;
import dev.Cursos.cursos.Curso.CursoRepository;
import dev.Cursos.cursos.Post.dto.PostRequestDTO;
import dev.Cursos.cursos.Post.dto.PostResponseDTO;
import dev.Cursos.cursos.exceptions.ResourceNotFoundException;

@Service
public class PostService {

    private PostRepository postRepository;
    private CursoRepository cursoRepository;
    private PostMapper postMapper;

    public PostService(PostRepository postRepository, CursoRepository cursoRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.cursoRepository = cursoRepository;
        this.postMapper = postMapper;
    }

    public Page<PostResponseDTO> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(postMapper::toResponse);
    }

    public PostResponseDTO getPostById(Long id) {
        return postRepository.findById(id)
                .map(postMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Post com ID " + id + " não encontrada."));
    }

    public PostResponseDTO createPost(PostRequestDTO dto) {
        CursoModel curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso com ID " + dto.cursoId() + " não encontrado."));

        PostModel post = postMapper.toModel(dto, curso);
        PostModel saved = postRepository.save(post);

        return postMapper.toResponse(saved);
    }

    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException("Post com ID " + id + " não encontrada para exclusão.");
        }
        postRepository.deleteById(id);
    }
}
