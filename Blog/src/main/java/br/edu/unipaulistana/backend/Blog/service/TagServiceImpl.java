package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Tag;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> findAllTags() {
        return this.tagRepository.findAllTags();
    }

    @Override
    public Optional<Tag> findTagById(Long id) {
        return this.tagRepository.findTagById(id);
    }

    @Override
    public Optional<Tag> findTagByName(String name) {
        return this.tagRepository.findTagByName(name);
    }

    @Override
    public void deleteTagById(Long id) {
        this.tagRepository.deleteById(id);
    }

    @Override
    public Tag create(Tag tag) {
        return this.tagRepository.save(tag);
    }

    @Override
    public Tag update(Tag tag) {
        return this.tagRepository.save(tag);
    }

    @Override
    public Tag partialUpdate(Tag tag) {
        return this.tagRepository.save(tag);
    }
}

