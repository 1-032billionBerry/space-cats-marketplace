package com.example.spacecatsmarketplace.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryValidator implements ConstraintValidator<ValidCategory, List<String>> {

  private static final Set<String> SPACE_WORDS = Set.of(
      "star", "galaxy", "space", "cosmo", "planet", "universe", "orbit", "astronaut", "nebula"
  );

  @Override
  public boolean isValid(List<String> categories, ConstraintValidatorContext context) {
    return categories.stream()
        .allMatch(category -> SPACE_WORDS.stream()
            .anyMatch(category.toLowerCase()::contains));
  }
}
