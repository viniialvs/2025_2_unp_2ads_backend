package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT t.id FROM Tag t")
    public Optional<Tag> findTagById(Long id);

    @Query("SELECT t FROM Tag t")
    public List<Tag> findAllTags();

    @Query("SELECT t.name FROM Tag t")
    public Optional<Tag> findTagByName(String name);
}
