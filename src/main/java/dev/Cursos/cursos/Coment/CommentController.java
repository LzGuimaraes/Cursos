package dev.Cursos.cursos.Coment;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/comment")
public class CommentController {
   @GetMapping("/all")
    public String getComment() {
        return "List of Comment";
    }

    @GetMapping("/all/{id}")
    public String getCommentById() {
        return "Comment By Id: ";
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
