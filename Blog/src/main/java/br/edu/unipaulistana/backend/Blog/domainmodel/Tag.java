package br.edu.unipaulistana.backend.Blog.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TBL_TAGS")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private @Getter @Setter Long id;

    @Column(name = "NAME", nullable = false)
    private @Getter @Setter String name;

    @ManyToMany
    private @Getter @Setter Set<Post> posts;
}
