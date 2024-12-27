package com.example.spacecatsmarketplace.service.mapper;

import com.example.spacecatsmarketplace.common.CategoryType;
import com.example.spacecatsmarketplace.domain.Product;
import com.example.spacecatsmarketplace.dto.ProductDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  @Mapping(target = "productReference", source = "productReference")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "description", source = "description")
  @Mapping(target = "price", source = "price")
  @Mapping(target = "categories", source = "categories", qualifiedByName = "toCategoriesString")
  ProductDto toProductDto(Product product);

  @Mapping(target = "productReference", expression = "java(java.util.UUID.randomUUID())")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "description", source = "description")
  @Mapping(target = "price", source = "price")
  @Mapping(target = "categories", source = "categories", qualifiedByName = "toCategoriesType")
  Product toProduct(ProductDto productDto);

  @Named("toCategoriesString")
  default List<String> toCategoriesString(List<CategoryType> categoriesType) {
    return categoriesType.stream()
        .map(CategoryType::getDisplayName)
        .toList();
  }

  @Named("toCategoriesType")
  default List<CategoryType> toCategoriesType(List<String> categoriesString) {
    return categoriesString.stream()
        .map((categoryString) -> CategoryType.valueOf(categoryString.toUpperCase()))
        .toList();
  }
}
