package com.example.spacecatsmarketplace.domain;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Order {

  private UUID orderNumber;
  private List<Product> products;
}
