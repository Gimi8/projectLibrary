package pl.sda.project.libraryproject.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.project.libraryproject.validator.Age;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
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
