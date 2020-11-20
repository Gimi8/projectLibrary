package pl.sda.project.libraryproject.external.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 100)
    private String username;

    private String password;

    private String role;


    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    private int age;


}
