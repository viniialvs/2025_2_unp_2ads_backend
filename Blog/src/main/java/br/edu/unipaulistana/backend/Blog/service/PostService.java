package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import br.edu.unipaulistana.backend.Blog.domainmodel.User;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAll();

    Optional<Post> findPostById(Long id);

    Optional<Post> findPostTitle(String title);

    Optional<Post> findPostContent(String content);

    List<Post> findPostsByUser(User user);

    Post create(Post post);

    Post update(Post post);

    Post partialUpdate(Post post);

    void deletePostById(Long id);
}
