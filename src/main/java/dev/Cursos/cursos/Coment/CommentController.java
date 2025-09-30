package dev.Cursos.cursos.Coment;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public List<CommentModel> getAllComment() {
        return commentService.getAllComment();
    }

    @GetMapping("/all/{id}")
    public CommentModel getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping("create")
    public String createComment() {
        return "Comment created: ";
    }

    @PutMapping("alter/{id}")
    public String alterComment() {
        return "Comment altered: ";
    }
    @DeleteMapping("delete/{id}")
    public String deleteComment() {
        return "Comment deleted: ";
    }
}
