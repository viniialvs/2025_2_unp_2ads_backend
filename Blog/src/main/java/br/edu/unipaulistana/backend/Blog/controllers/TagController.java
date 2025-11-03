package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.service.TagService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
@Tag(name = "Tags", description = "Operações relativas às tags")
public class TagController {

    private final TagService tagService;

    @GetMapping
    public ResponseEntity<List<br.edu.unipaulistana.backend.Blog.domainmodel.Tag>> findAllTags(){
        return ResponseEntity.ok(this.tagService.findAllTags());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Tag>> findTagById(@PathVariable Long id){
        return ResponseEntity.ok(this.tagService.findTagById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Optional<br.edu.unipaulistana.backend.Blog.domainmodel.Tag>> findTagByName(@RequestParam String name){
        return ResponseEntity.ok(this.tagService.findTagByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTagById(@PathVariable Long id){
        this.tagService.deleteTagById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<br.edu.unipaulistana.backend.Blog.domainmodel.Tag> createTag(@RequestBody br.edu.unipaulistana.backend.Blog.domainmodel.Tag tag){
        return new ResponseEntity<>(this.tagService.create(tag), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<br.edu.unipaulistana.backend.Blog.domainmodel.Tag> updateTag(@RequestBody br.edu.unipaulistana.backend.Blog.domainmodel.Tag tag){
        return new ResponseEntity<>(this.tagService.update(tag), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<br.edu.unipaulistana.backend.Blog.domainmodel.Tag> patchTag(@RequestBody br.edu.unipaulistana.backend.Blog.domainmodel.Tag tag){
        return new ResponseEntity<>(this.tagService.partialUpdate(tag), HttpStatus.CREATED);
    }
}
