package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r.id FROM Role r")
    public Optional<Role> findRoleById(Long id);

    @Query("SELECT r FROM Role r")
    public List<Role> findAllRoles();

    @Query("SELECT r.name FROM Role r")
    public Optional<Role> findRoleByName(String name);

}
