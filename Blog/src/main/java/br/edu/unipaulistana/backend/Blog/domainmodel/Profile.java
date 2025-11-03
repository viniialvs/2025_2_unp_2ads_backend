package br.edu.unipaulistana.backend.Blog.domainmodel;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TBL_PROFILES")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private @Getter @Setter Long id;

    @Column(name = "BIO", nullable = false)
    private @Getter @Setter String bio;

    @Column(name = "PICTUREURL", nullable = false)
    private @Getter @Setter String pictureUrl;

    @OneToOne
    private @Getter @Setter User user;
}
