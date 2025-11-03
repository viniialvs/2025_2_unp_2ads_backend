package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> findAllRoles() {
        return this.roleRepository.findAllRoles();
    }

    @Override
    public Optional<Role> findRoleById(Long id) {
        return this.roleRepository.findRoleById(id);
    }

    @Override
    public Optional<Role> findRoleByName(String name) {
        return this.roleRepository.findRoleByName(name);
    }

    @Override
    public Role create(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role partialUpdate(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public void deleteRoleById(Long id) {
        this.roleRepository.deleteById(id);
    }
}
