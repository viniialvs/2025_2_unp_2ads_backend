package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<Tag> findAllTags();

    Optional<Tag> findTagById(Long id);

    Optional<Tag> findTagByName(String name);

    void deleteTagById(Long id);

    Tag create(Tag tag);

    Tag update(Tag tag);

    Tag partialUpdate(Tag tag);
}
