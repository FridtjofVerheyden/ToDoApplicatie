package be.vdab.todoapplicatie;

import jakarta.validation.ConstraintValidator;

public class PrioriteitValidator implements ConstraintValidator<Prioriteit, Integer> {
    @Override
    public boolean isValid(Integer prioriteit, jakarta.validation.ConstraintValidatorContext constraintValidatorContext) {
        return prioriteit == null || prioriteit >= 1 && prioriteit <= 10;
    }
}
