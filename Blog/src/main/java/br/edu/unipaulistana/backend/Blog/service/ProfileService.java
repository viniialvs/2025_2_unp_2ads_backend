package br.edu.unipaulistana.backend.Blog.service;


import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;


import java.util.List;
import java.util.Optional;

public interface ProfileService {

    List<Profile> findAllProfiles();

    Optional<Profile> findProfileById(Long id);

    Optional<Profile> findProfileBio(String bio);

    Optional<Profile> findProfilePictureUrl(String pictureUrl);

    Profile create(Profile profile);

    Profile update(Profile profile);

    Profile partialUpdate(Profile profile);

    void deleteProfileById(Long id);
}
