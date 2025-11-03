package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;
import br.edu.unipaulistana.backend.Blog.service.ProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
@Tag(name = "Profiles", description = "Operações relativas às profiles")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<Profile>> findAllProfiles() {
        return ResponseEntity.ok(this.profileService.findAllProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Profile>> findProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(this.profileService.findProfileById(id));
    }

    @GetMapping("/search-bio")
    public ResponseEntity<Optional<Profile>> findProfileBio(@RequestParam String bio) {
        return ResponseEntity.ok(this.profileService.findProfileBio(bio));
    }

    @GetMapping("/search-pictureUrl")
    public ResponseEntity<Optional<Profile>> findProfilePictureUrl(@RequestParam String pictureUrl) {
        return ResponseEntity.ok(this.profileService.findProfilePictureUrl(pictureUrl));
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(this.profileService.create(profile), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(this.profileService.update(profile), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Profile> patchProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(this.profileService.partialUpdate(profile), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfileById(@PathVariable Long id) {
        this.profileService.deleteProfileById(id);
        return ResponseEntity.ok().build();
    }
}
