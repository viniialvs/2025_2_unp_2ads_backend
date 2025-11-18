package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public User create(User user) {
       return this.repository.save(user);
    }

    @Override
    public User update(User user) {
        return this.repository.save(user);
    }

    @Override
    public User partialUpdate(User user) {
        return this.repository.save(user);
    }

    public Optional<User> findByIdWithProfileAndPostsCriteria(UUID id) {
        return repository.findByIdWithProfileAndPostsCriteria(id);
    }

    public List<User> findByMinRolesAndNameLikeCriteria(int minRoles, String name) {
        return repository.findByMinRolesAndNameLikeCriteria(minRoles, name);
    }

    public Optional<User> findMinRolesAndNameLike(int minRoles, String namePart) {
        return repository.findMinRolesAndNameLike(minRoles, namePart);
    }

    public Optional<User> findByIdWithProfileAndPosts (UUID id) {
        return repository.findByIdWithProfileAndPosts(id);
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Optional<User> findByName(String name) {
        return repository.findByName(name);
    }

    public Optional<User> findByNameAndEmail(String name, String email) {
        return repository.findByNameAndEmail(name, email);
    }

    public List<User> findByNameStartingWithAndNameEndingWith(String name1, String name2) {
        return repository.findByNameStartingWithAndNameEndingWith(name1, name2);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByName(username).get();
    }
}
