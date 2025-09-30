package dev.Cursos.cursos.Coment;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public List<CommentModel> getAllComment(){
        return commentRepository.findAll();
    }
    public CommentModel getCommentById(Long id){
        Optional<CommentModel> comment = commentRepository.findById(id);
        return comment.orElse(null);
    }
}
