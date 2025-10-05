package dev.Cursos.cursos.Coment;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Coment.dto.CommentRequestDTO;
import dev.Cursos.cursos.Coment.dto.CommentResponseDTO;
import dev.Cursos.cursos.Post.PostModel;
import dev.Cursos.cursos.Post.PostRepository;


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

    public List<CommentResponseDTO> getAllComments() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CommentResponseDTO getCommentById(Long id) {
        return commentRepository.findById(id)
                .map(commentMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
    }
    public CommentResponseDTO createComment(CommentRequestDTO dto) {
        PostModel post = postRepository.findById(dto.postId())
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        CommentModel comment = commentMapper.toModel(dto, post);
        CommentModel saved = commentRepository.save(comment);
        return commentMapper.toResponse(saved);
    
    }

    public CommentResponseDTO updateComment(Long id, CommentRequestDTO dto) {
        CommentModel existing = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));

        existing.setDescricao(dto.descricao());
        CommentModel updated = commentRepository.save(existing);
        return commentMapper.toResponse(updated);
    }

    public void deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new RuntimeException("Comentário não encontrado");
        }
        commentRepository.deleteById(id);
    }
}
