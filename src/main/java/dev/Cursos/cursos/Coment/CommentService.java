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
    public CommentModel createComment(CommentModel comment){
        return commentRepository.save(comment);
    }
    public void deleteComment(Long id, CommentModel newComment){
        commentRepository.deleteById(id);
    }
    public CommentModel alterComment(Long id, CommentModel commentAtualizado){
        if(commentRepository.existsById(id)){
            commentAtualizado.setId_comment(id);
            return commentRepository.save(commentAtualizado);
        }
        return null;
    }

}
