package com.example.spacecatsmarketplace.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {

  private Long id;
  private String name;
  private String email;
}
