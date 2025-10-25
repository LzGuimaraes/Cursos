package dev.Cursos.cursos.Coment;

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

import dev.Cursos.cursos.Coment.dto.CommentRequestDTO;
import dev.Cursos.cursos.Coment.dto.CommentResponseDTO;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<CommentResponseDTO>> getAllComments(Pageable pageable) {
        Page<CommentResponseDTO> comment = commentService.getAllComments(pageable);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/all/{id}")
    public CommentResponseDTO getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping("create")
    public ResponseEntity<CommentResponseDTO> createComment(@Valid @RequestBody CommentRequestDTO dto) {
        CommentResponseDTO created = commentService.createComment(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public void deletePost(@PathVariable Long id) {
        commentService.deletePost(id);
    }
}
