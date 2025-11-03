package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import br.edu.unipaulistana.backend.Blog.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@Tag(name = "Posts", description = "Operações relativas às posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAllPosts() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> findPostById(@PathVariable Long id) {
        return ResponseEntity.ok(this.postService.findPostById(id));
    }

    @GetMapping("/search-title")
    public ResponseEntity<Optional<Post>> findPostByTitle(@RequestParam String title) {
        return ResponseEntity.ok(this.postService.findPostTitle(title));
    }

    @GetMapping("/search-content")
    public ResponseEntity<Optional<Post>> findPostByContent(@RequestParam String content) {
        return ResponseEntity.ok(this.postService.findPostContent(content));
    }

    @GetMapping("/search-userPosts")
    public ResponseEntity<List<Post>> findPostsByUser(@RequestParam User user) {
        return ResponseEntity.ok(this.postService.findPostsByUser(user));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(this.postService.create(post), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        return new ResponseEntity<>(this.postService.update(post), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Post> patchPost(@RequestBody Post post) {
        return new ResponseEntity<>(this.postService.partialUpdate(post), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        this.postService.deletePostById(id);
        return ResponseEntity.ok().build();
    }
}
