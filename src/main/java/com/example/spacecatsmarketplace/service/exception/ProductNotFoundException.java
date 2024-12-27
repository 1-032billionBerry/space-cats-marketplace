package com.example.spacecatsmarketplace.service.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {

  private static final String REFERENCE_NOT_FOUND = "Product with reference '%s' not found";

  public ProductNotFoundException(UUID reference) {
    super(String.format(REFERENCE_NOT_FOUND, reference));
  }
}
