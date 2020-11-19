package pl.sda.project.libraryproject.domain.book;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class Book {

private Long id;
@NotBlank
private String title;
    @NotBlank
private String author;
//    @Positive(message = "quantity could not be negative")
private int quantity;

}
