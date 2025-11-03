package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(UUID id);

    void deleteById(UUID id);

    User create(User user);

    User update(User user);

    User partialUpdate(User user);

    Optional<User> findByIdWithProfileAndPostsCriteria(UUID id);

    List<User> findByMinRolesAndNameLikeCriteria(int minRoles, String name);

    Optional<User> findByIdWithProfileAndPosts (@Param("ID") UUID id);

    Optional<User> findByEmail (String email);

    Optional<User> findByName (String name);

    Optional<User> findByNameAndEmail (String name, String email);

    Optional<User> findMinRolesAndNameLike(int minRoles, String namePart);

    List<User> findByNameStartingWithAndNameEndingWith(String name1, String name2);
}
