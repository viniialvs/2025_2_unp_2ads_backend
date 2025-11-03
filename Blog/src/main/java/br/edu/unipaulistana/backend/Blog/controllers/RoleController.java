package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;
import br.edu.unipaulistana.backend.Blog.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@Tag(name = "Roles", description = "Operações relativas às roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> findAllRoles() {
        return ResponseEntity.ok(this.roleService.findAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Role>> findRoleById(@PathVariable Long id) {
        return ResponseEntity.ok(this.roleService.findRoleById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Optional<Role>> findRoleByName(@RequestParam String name){
        return ResponseEntity.ok(this.roleService.findRoleByName(name));
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<>(this.roleService.create(role), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody Role role){
        return new ResponseEntity<>(this.roleService.update(role), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Role> patchRole(@RequestBody Role role){
        return new ResponseEntity<>(this.roleService.partialUpdate(role), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable Long id){
        this.roleService.deleteRoleById(id);
        return ResponseEntity.ok().build();
    }
}
