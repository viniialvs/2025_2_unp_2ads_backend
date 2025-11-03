package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.ProfileRepository;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public List<Profile> findAllProfiles() {
        return this.profileRepository.findAllProfiles();
    }

    @Override
    public Optional<Profile> findProfileById(Long id) {
        return this.profileRepository.findProfileById(id);
    }

    @Override
    public Optional<Profile> findProfileBio(String bio) {
        return this.profileRepository.findProfileBio(bio);
    }

    @Override
    public Optional<Profile> findProfilePictureUrl(String pictureUrl) {
        return this.profileRepository.findProfilePictureUrl(pictureUrl);
    }

    @Override
    public Profile create(Profile profile) {
        return this.profileRepository.save(profile);
    }

    @Override
    public Profile update(Profile profile) {
        return this.profileRepository.save(profile);
    }

    @Override
    public Profile partialUpdate(Profile profile) {
        return this.profileRepository.save(profile);
    }

    @Override
    public void deleteProfileById(Long id) {
        this.profileRepository.deleteById(id);
    }
}
