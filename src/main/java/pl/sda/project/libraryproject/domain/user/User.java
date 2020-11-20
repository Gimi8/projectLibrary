package pl.sda.project.libraryproject.domain.user;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.project.libraryproject.validator.Age;

import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class User {

    private Long id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @Age
    private int age;

    private String username;
    private String password;
    private String role;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
    }
}
