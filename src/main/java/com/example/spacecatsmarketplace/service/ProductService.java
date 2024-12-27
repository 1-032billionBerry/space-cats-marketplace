package com.example.spacecatsmarketplace.service;

import com.example.spacecatsmarketplace.domain.Product;
import java.util.List;
import java.util.UUID;

public interface ProductService {

  List<Product> getAllProducts();

  Product getProductByReference(UUID productReference);

  Product createProduct(Product product);

  Product updateProduct(Product product);

  void deleteProductByReference(UUID productReference);
}
