package dev.Cursos.cursos.Coment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Coment.dto.CommentRequestDTO;
import dev.Cursos.cursos.Coment.dto.CommentResponseDTO;
import dev.Cursos.cursos.Post.PostModel;
import dev.Cursos.cursos.Post.PostRepository;
import dev.Cursos.cursos.exceptions.ResourceNotFoundException;


@Service
public class CommentService {
    private CommentRepository commentRepository;
    private CommentMapper commentMapper;
    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.postRepository = postRepository;
    }

    public Page<CommentResponseDTO> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(commentMapper::toResponse);
    }

    public CommentResponseDTO getCommentById(Long id) {
        return commentRepository.findById(id)
                .map(commentMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Post com ID " + id + " não encontrada."));
    }
    public CommentResponseDTO createComment(CommentRequestDTO dto) {
        PostModel post = postRepository.findById(dto.postId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso com ID " + dto.postId() + " não encontrado."));

        CommentModel comment = commentMapper.toModel(dto, post);
        CommentModel saved = commentRepository.save(comment);
        return commentMapper.toResponse(saved);
    
    }

    public CommentResponseDTO updateComment(Long id, CommentRequestDTO dto) {
        CommentModel existing = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso com ID " + id+ " não encontrado."));

        existing.setDescricao(dto.descricao());
        CommentModel updated = commentRepository.save(existing);
        return commentMapper.toResponse(updated);
    }

    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException("Comentario com ID " + id + " não encontrada para exclusão.");
        }
        postRepository.deleteById(id);
    }
}
