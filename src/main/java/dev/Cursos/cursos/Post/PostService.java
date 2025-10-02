package dev.Cursos.cursos.Post;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;
    private PostMapper postMapper;

    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public List<PostDTO> getAllPost(){
        List<PostModel> posts = postRepository.findAll();        
        return posts.stream().map(postMapper::map).collect(Collectors.toList());
    }

    public PostDTO getPostById(Long id){
        Optional<PostModel> postById = postRepository.findById(id);
        return postById.map(postMapper::map).orElse(null);
    }
    public PostDTO createPost(PostDTO postDTO){
        PostModel postModel = postMapper.map(postDTO);
        postModel = postRepository.save(postModel);
        return postMapper.map(postModel);
    }
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
    public PostDTO alterPost(Long id, PostDTO postDTO){
        Optional<PostModel> existingPost = postRepository.findById(id);
        if (existingPost.isPresent()) {
            PostModel postUpdated = postMapper.map(postDTO);
            postUpdated.setId_post(id);
            PostModel postSaved = postRepository.save(postUpdated);
            return postMapper.map(postSaved);
        }
        return null;
    }
}
