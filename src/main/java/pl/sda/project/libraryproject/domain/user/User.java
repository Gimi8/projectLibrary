package pl.sda.project.libraryproject.domain.user;

import lombok.*;
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


}
