package be.vdab.todoapplicatie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;


public record NieuweTodo(@NotNull @PositiveOrZero Long mensId, @NotBlank String tekst, @Prioriteit int prioriteit) {
}
