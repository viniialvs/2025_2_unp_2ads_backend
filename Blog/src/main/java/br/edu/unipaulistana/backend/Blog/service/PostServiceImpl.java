package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAllPosts();
    }

    @Override
    public Optional<Post> findPostById(Long id) {
        return this.postRepository.findPostById(id);
    }

    @Override
    public Optional<Post> findPostTitle(String title) {
        return this.postRepository.findPostTitle(title);
    }

    @Override
    public Optional<Post> findPostContent(String content) {
        return this.postRepository.findPostContent(content);
    }

    @Override
    public List<Post> findPostsByUser(User user) {
        return this.postRepository.findPostsByUser(user);
    }

    @Override
    public Post create(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public Post partialUpdate(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public void deletePostById(Long id) {
        this.postRepository.deleteById(id);
    }
}
