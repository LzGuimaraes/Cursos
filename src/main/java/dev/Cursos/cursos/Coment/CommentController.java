package dev.Cursos.cursos.Coment;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

   @GetMapping("/all")
    public List<CommentDTO> getAllComment() {
        return commentService.getAllComment();
    }

    @GetMapping("/all/{id}")
    public CommentDTO getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping("create")
    public CommentDTO createComment(@RequestBody CommentDTO comment) {
        return commentService.createComment(comment);
    }

    @PutMapping("alter/{id}")
    public CommentDTO alterComment(@PathVariable Long id, @RequestBody CommentDTO commentAtualizado) {
        return commentService.alterComment(id, commentAtualizado);
    }

    @DeleteMapping("delete/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id, null);
    }
}
