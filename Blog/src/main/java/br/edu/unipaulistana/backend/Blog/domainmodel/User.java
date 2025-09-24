package br.edu.unipaulistana.backend.Blog.domainmodel;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private @Getter Long id;
    private @Getter String name;
    private @Getter String email;
    private @Getter String password;
    private @Getter List<Role> roles;
    private @Getter Profile profile;
}

