package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> findAllRoles();

    Optional<Role> findRoleById(Long id);

    Optional<Role> findRoleByName(String name);

    Role create(Role role);

    Role update(Role role);

    Role partialUpdate(Role role);

    void deleteRoleById(Long id);
}
