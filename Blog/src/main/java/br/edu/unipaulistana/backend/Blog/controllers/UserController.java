package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.NonPersistentUserRepository;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.UserRepository;
import br.edu.unipaulistana.backend.Blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(this.userService.findAll());
    }

    //    GET http://localhost:8080/api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable UUID id){
        return ResponseEntity.ok(this.userService.findById(id));
    }

    //DELETE http://localshot:8080/api/users/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID id){
        this.userService.deleteById(id);
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.create(user),  HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.update(user),  HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<User> patchUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.partialUpdate(user), HttpStatus.CREATED);
    }

    // GET http://localhost:8080/api/users/query-criteria/{id}
    @GetMapping("/query-criteria/{id}")
    public ResponseEntity<Optional<User>> getUserByIdCriteria(@PathVariable UUID id){
        return ResponseEntity.ok(this.userService.findByIdWithProfileAndPostsCriteria(id));
    }

    // GET http://localhost:8080/api/users/search-criteria
    @GetMapping("/search-criteria")
    public ResponseEntity<List<User>> searchUserByNameAndRolesCriteria(@RequestParam String name, @RequestParam int minRoles){
        return ResponseEntity.ok(this.userService.findByMinRolesAndNameLikeCriteria(minRoles, name));
    }

    // GET http://localhost:8080/api/users/query-JPQL
    @GetMapping("/query-JPQL/{id}")
    public ResponseEntity<Optional<User>> getUserByIdWithProfileAndPostsJPQL(@PathVariable UUID id) {
        return ResponseEntity.ok(this.userService.findByIdWithProfileAndPosts(id));
    }

    // GET http://localhost:8080/api/users/search-JPQL
    @GetMapping("/search-JPQL")
    public ResponseEntity<Optional<User>> searchUserMinRolesAndNameLikeJPQl(@RequestParam int minRoles, @RequestParam String namePart) {
        return ResponseEntity.ok(this.userService.findMinRolesAndNameLike(minRoles, namePart));
    }

    // GET http://localhost:8080/api/users/emailJPQL
    @GetMapping("/emailJPQL")
    public ResponseEntity<Optional<User>> getUserByEmailJPQL(@RequestParam String email) {
        return ResponseEntity.ok(this.userService.findByEmail(email));
    }

    // GET http://localhost:8080/api/users/nameJPQL
    @GetMapping("/nameJPQL")
    public ResponseEntity<Optional<User>> getUserByNameJPQL(@RequestParam String name) {
        return ResponseEntity.ok(this.userService.findByName(name));
    }

    // GET http://localhost:8080/api/users/nameAndEmailJPQL
    @GetMapping("/nameAndEmailJPQL")
    public ResponseEntity<Optional<User>> getUserByNameAndEmailJPQL(@RequestParam String name, @RequestParam String email) {
        return ResponseEntity.ok(this.userService.findByNameAndEmail(name, email));
    }

    // GET http://localhost:8080/api/users/name-rangeJPQL
    @GetMapping("/name-rangeJPQL")
    public ResponseEntity<List<User>> getUserByNameRange(@RequestParam String name1, @RequestParam String name2) {
        return ResponseEntity.ok(this.userService.findByNameStartingWithAndNameEndingWith(name1, name2));
    }
}