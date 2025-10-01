package dev.Cursos.cursos.Post;

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
@RequestMapping("/Post")
public class PostController {
    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public List<PostModel> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/all/{id}")
    public PostModel getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("create")
    public PostModel createPost(@RequestBody PostModel post) {
        return postService.createPost(post);
    }

    @PutMapping("alter/{id}")
    public PostModel alterPost(@PathVariable Long id, @RequestBody PostModel updatedPost) {
        return postService.alterPost(id, updatedPost);
    }
    @DeleteMapping("delete/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
