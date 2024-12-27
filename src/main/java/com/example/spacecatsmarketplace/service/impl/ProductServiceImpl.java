package com.example.spacecatsmarketplace.service.impl;

import com.example.spacecatsmarketplace.common.CategoryType;
import com.example.spacecatsmarketplace.domain.Product;
import com.example.spacecatsmarketplace.service.ProductService;
import com.example.spacecatsmarketplace.service.exception.ProductNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private final List<Product> products = loadProducts();

  @Override
  public List<Product> getAllProducts() {
    return products;
  }

  @Override
  public Product getProductByReference(UUID productReference) {
    return products.stream()
        .filter(product -> product.getProductReference().equals(productReference))
        .findFirst()
        .orElseThrow(() -> new ProductNotFoundException(productReference));
  }

  @Override
  public Product createProduct(Product product) {
    products.add(product);
    return product;
  }

  @Override
  public Product updateProduct(Product product) {
    Product existingProduct = getProductByReference(product.getProductReference());
    products.remove(existingProduct);
    products.add(product);
    return product;
  }

  @Override
  public void deleteProductByReference(UUID productReference) {
    products.removeIf(product -> product.getProductReference().equals(productReference));
  }

  private List<Product> loadProducts() {
    List<Product> products = new ArrayList<>();
    products.add(Product.builder()
        .productReference(UUID.randomUUID())
        .name("wool T-Shirt")
        .description("A T-shirt with the cats logo")
        .price(20)
        .categories(List.of(CategoryType.SPACE_CLOTHES))
        .build());
    products.add(Product.builder()
        .productReference(UUID.randomUUID())
        .name("Catnip Sticker")
        .description("A sticker with the catnip image")
        .price(5)
        .categories(List.of(CategoryType.ORBIT_ACCESSORIES))
        .build());
    products.add(Product.builder()
        .productReference(UUID.randomUUID())
        .name("lightning cat")
        .description("Lightning saber only for astronaut cats")
        .price(250)
        .categories(List.of(CategoryType.ASTRONAUT_ELECTRONICS))
        .build());
    return products;
  }
}
