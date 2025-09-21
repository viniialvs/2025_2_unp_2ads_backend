package br.edu.unipaulistana.backend.Blog.domainmodel;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private @Getter @Setter Long id;
    private @Getter @Setter String name;
    private @Getter @Setter String email;
    private @Getter @Setter String password;
    private @Getter @Setter List<Role> roles;
    private @Getter @Setter Profile profile;
}

