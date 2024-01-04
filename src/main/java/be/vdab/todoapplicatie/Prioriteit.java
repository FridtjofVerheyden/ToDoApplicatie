package be.vdab.todoapplicatie;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@PositiveOrZero
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PrioriteitValidator.class})
@ReportAsSingleViolation
@NotNull
public @interface Prioriteit {
    String message() default "Prioriteit must be between 1 and 10";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
