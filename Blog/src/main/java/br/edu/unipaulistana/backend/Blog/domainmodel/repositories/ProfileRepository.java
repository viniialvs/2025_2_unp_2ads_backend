package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT p FROM Profile p")
    public List<Profile> findAllProfiles();

    @Query("SELECT p.id FROM Profile p")
    public Optional<Profile> findProfileById(Long id);

    @Query("SELECT p.bio FROM Profile p")
    public Optional<Profile> findProfileBio(String bio);

    @Query("SELECT p.pictureUrl FROM Profile p")
    public Optional<Profile> findProfilePictureUrl(String pictureUrl);
}
