package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p")
    public List<Post> findAllPosts();

    @Query("SELECT p.id FROM Post p")
    public Optional<Post> findPostById(Long id);

    @Query("SELECT p.title FROM Post p")
    public Optional<Post> findPostTitle(String title);

    @Query("SELECT p.content FROM Post p")
    public Optional<Post> findPostContent(String content);

    @Query("SELECT p FROM Post p WHERE p.user = :user")
    public List<Post> findPostsByUser(@Param("user") User user);
}
