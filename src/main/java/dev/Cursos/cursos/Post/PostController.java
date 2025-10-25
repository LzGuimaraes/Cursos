package dev.Cursos.cursos.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Cursos.cursos.Post.dto.PostRequestDTO;
import dev.Cursos.cursos.Post.dto.PostResponseDTO;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/Post")
public class PostController {
    private PostService postService;
    
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<PostResponseDTO>> getAllPosts(Pageable pageable) {
        Page<PostResponseDTO> post = postService.getAllPosts(pageable);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/all/{id}")
    public PostResponseDTO getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<PostResponseDTO> create(@Valid @RequestBody PostRequestDTO dto) {
        PostResponseDTO created = postService.createPost(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
