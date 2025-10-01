package dev.Cursos.cursos.Post;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<PostModel> getAllPost(){
        return postRepository.findAll();
    }
    public PostModel getPostById(Long id){
        Optional<PostModel> post = postRepository.findById(id);
        return post.orElse(null);
    }
    public PostModel createPost(PostModel post){
        return postRepository.save(post);
    }
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
    public PostModel alterPost(Long id, PostModel updatedPost){
        if(postRepository.existsById(id)){
            updatedPost.setId_post(id);
            return postRepository.save(updatedPost);
        }
        return null;
    }
}
