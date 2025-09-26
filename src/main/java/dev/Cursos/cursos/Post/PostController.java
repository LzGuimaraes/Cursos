package dev.Cursos.cursos.Post;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Post")
public class PostController {
    @GetMapping("/all")
    public String getPost() {
        return "List of Post";
    }

    @GetMapping("/all/{id}")
    public String getPostById() {
        return "Post By Id: ";
    }

    @PostMapping("create")
    public String createPost() {
        return "Post created: ";
    }

    @PutMapping("alter/{id}")
    public String alterPost() {
        return "Post altered: ";
    }
    @DeleteMapping("delete/{id}")
    public String deletePost() {
        return "Post deleted: ";
    }
}
