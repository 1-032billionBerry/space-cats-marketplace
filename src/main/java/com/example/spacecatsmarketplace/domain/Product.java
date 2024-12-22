package com.example.spacecatsmarketplace.domain;

import com.example.spacecatsmarketplace.common.CategoryType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {

  private Long id;
  private String name;
  private String description;
  private Integer price;
  private List<CategoryType> categories;
}
