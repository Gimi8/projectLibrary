package pl.sda.project.libraryproject.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

    String message() default "The person must be of legal age";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
