package pl.sda.project.libraryproject.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    @Override
    public void initialize(Age constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext context) {


        return age != null && age >= 18;
    }
}
