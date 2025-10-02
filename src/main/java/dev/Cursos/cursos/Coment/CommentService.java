package dev.Cursos.cursos.Coment;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class CommentService {
    private CommentRepository commentRepository;
    private CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper CommentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = CommentMapper;
    }
    public List<CommentDTO> getAllComment(){
        List<CommentModel> comments = commentRepository.findAll();
        return comments.stream().map(commentMapper::map).collect(Collectors.toList());
    }
    public CommentDTO getCommentById(Long id){
        Optional<CommentModel> commentById = commentRepository.findById(id);
        return commentById.map(commentMapper::map).orElse(null);
    }
    public CommentDTO createComment(CommentDTO comment){
        CommentModel commentModel = commentMapper.map(comment);
        commentModel = commentRepository.save(commentModel);
        return commentMapper.map(commentModel);
    }
    public void deleteComment(Long id, CommentModel newComment){
        commentRepository.deleteById(id);
    }

    public CommentDTO alterComment(Long id, CommentDTO commentAtualizado){
        Optional<CommentModel> existingComment = commentRepository.findById(id);
        if (existingComment.isPresent()) {
            CommentModel commentUpdated = commentMapper.map(commentAtualizado);
            commentUpdated.setId_comment(id);
            CommentModel commentSaved = commentRepository.save(commentUpdated);
            return commentMapper.map(commentSaved);
        }
        return null;
    }

}
