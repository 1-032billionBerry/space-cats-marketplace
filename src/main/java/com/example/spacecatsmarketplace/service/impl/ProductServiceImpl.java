package com.example.spacecatsmarketplace.service.impl;

import com.example.spacecatsmarketplace.common.CategoryType;
import com.example.spacecatsmarketplace.domain.Product;
import com.example.spacecatsmarketplace.service.ProductService;
import com.example.spacecatsmarketplace.service.exception.ProductNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private final List<Product> products = loadProducts();
  private final AtomicLong idCounter = new AtomicLong(products.size());

  @Override
  public List<Product> getAllProducts() {
    return products;
  }

  @Override
  public Product getProductById(Long id) {
    return products.stream()
        .filter(product -> product.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @Override
  public Product createProduct(Product product) {
    product.setId(idCounter.incrementAndGet());
    products.add(product);
    return product;
  }

  @Override
  public Product updateProduct(Product product) {
    Product existingProduct = getProductById(product.getId());
    products.remove(existingProduct);
    products.add(product);
    return product;
  }

  @Override
  public void deleteProductById(Long id) {
    products.removeIf(product -> product.getId().equals(id));
  }

  private List<Product> loadProducts() {
    List<Product> products = new ArrayList<>();
    products.add(Product.builder()
        .id(1L)
        .name("wool T-Shirt")
        .description("A T-shirt with the cats logo")
        .price(20)
        .categories(List.of(CategoryType.SPACE_CLOTHES))
        .build());
    products.add(Product.builder()
        .id(3L)
        .name("Catnip Sticker")
        .description("A sticker with the catnip image")
        .price(5)
        .categories(List.of(CategoryType.ORBIT_ACCESSORIES))
        .build());
    products.add(Product.builder()
        .id(2L)
        .name("lightning cat")
        .description("Lightning saber only for astronaut cats")
        .price(250)
        .categories(List.of(CategoryType.ASTRONAUT_ELECTRONICS))
        .build());
    return products;
  }
}
