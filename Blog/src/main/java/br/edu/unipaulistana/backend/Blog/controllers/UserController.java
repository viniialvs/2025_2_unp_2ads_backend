package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import br.edu.unipaulistana.backend.Blog.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//http://locallhost:8080/users
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "Operações relativas à usuários")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(method = "GET", summary = "Listar todos os usuários")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(this.userService.findAll());
    }

    //    GET http://localhost:8080/api/users/{id}
    @GetMapping("/{id}")
    @Operation(method = "GET", summary = "Listar usuário pelo ID")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable UUID id){
        return ResponseEntity.ok(this.userService.findById(id));
    }

    //DELETE http://localshot:8080/api/users/{id}
    @DeleteMapping("/{id}")
    @Operation(method = "DELETE", summary = "Deletar usuário pelo ID")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID id){
        this.userService.deleteById(id);
        return ResponseEntity.ok().build();

    }

    @PostMapping
    @Operation(method = "POST", summary = "Criar usuário")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.create(user),  HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(method = "PUT", summary = "Atualizar usuário")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.update(user),  HttpStatus.CREATED);
    }

    @PatchMapping
    @Operation(method = "PATCH", summary = "usuário")
    public ResponseEntity<User> patchUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.partialUpdate(user), HttpStatus.CREATED);
    }

    // GET http://localhost:8080/api/users/query-criteria/{id}
    @GetMapping("/query-criteria/{id}")
    @Operation(method = "GET", summary = "Listar usuário por ID - Criteria")
    public ResponseEntity<Optional<User>> getUserByIdCriteria(@PathVariable UUID id){
        return ResponseEntity.ok(this.userService.findByIdWithProfileAndPostsCriteria(id));
    }

    // GET http://localhost:8080/api/users/search-criteria
    @GetMapping("/search-criteria")
    @Operation(method = "GET", summary = "Buscar usuário pelo Nome e pelas Roles - Criteria")
    public ResponseEntity<List<User>> searchUserByNameAndRolesCriteria(@RequestParam String name, @RequestParam int minRoles){
        return ResponseEntity.ok(this.userService.findByMinRolesAndNameLikeCriteria(minRoles, name));
    }

    // GET http://localhost:8080/api/users/query-JPQL
    @GetMapping("/query-JPQL/{id}")
    @Operation(method = "GET", summary = "Listar usuário por ID, com o Profile e os Posts - JPQL")
    public ResponseEntity<Optional<User>> getUserByIdWithProfileAndPostsJPQL(@PathVariable UUID id) {
        return ResponseEntity.ok(this.userService.findByIdWithProfileAndPosts(id));
    }

    // GET http://localhost:8080/api/users/search-JPQL
    @GetMapping("/search-JPQL")
    @Operation(method = "GET", summary = "Buscar usuário pelo Nome e quantidade de Roles - JPQL")
    public ResponseEntity<Optional<User>> searchUserMinRolesAndNameLikeJPQl(@RequestParam int minRoles, @RequestParam String namePart) {
        return ResponseEntity.ok(this.userService.findMinRolesAndNameLike(minRoles, namePart));
    }

    // GET http://localhost:8080/api/users/emailJPQL
    @GetMapping("/emailJPQL")
    @Operation(method = "GET", summary = "Listar usuário por Email - JPQL")
    public ResponseEntity<Optional<User>> getUserByEmailJPQL(@RequestParam String email) {
        return ResponseEntity.ok(this.userService.findByEmail(email));
    }

    // GET http://localhost:8080/api/users/nameJPQL
    @GetMapping("/nameJPQL")
    @Operation(method = "GET", summary = "Listar o usuário por Nome - JPQL")
    public ResponseEntity<Optional<User>> getUserByNameJPQL(@RequestParam String name) {
        return ResponseEntity.ok(this.userService.findByName(name));
    }

    // GET http://localhost:8080/api/users/nameAndEmailJPQL
    @GetMapping("/nameAndEmailJPQL")
    @Operation(method = "GET", summary = "Listar o usuário por Nome e Email - JPQL")
    public ResponseEntity<Optional<User>> getUserByNameAndEmailJPQL(@RequestParam String name, @RequestParam String email) {
        return ResponseEntity.ok(this.userService.findByNameAndEmail(name, email));
    }

    // GET http://localhost:8080/api/users/name-rangeJPQL
    @GetMapping("/name-rangeJPQL")
    @Operation(method = "GET", summary = "Listar o usuário pela primeira e última letra - JPQL")
    public ResponseEntity<List<User>> getUserByNameRange(@RequestParam String name1, @RequestParam String name2) {
        return ResponseEntity.ok(this.userService.findByNameStartingWithAndNameEndingWith(name1, name2));
    }
}