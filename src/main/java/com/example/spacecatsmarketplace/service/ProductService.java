package com.example.spacecatsmarketplace.service;

import com.example.spacecatsmarketplace.domain.Product;
import java.util.List;

public interface ProductService {

  List<Product> getAllProducts();

  Product getProductById(Long id);

  Product createProduct(Product product);

  Product updateProduct(Product product);

  void deleteProductById(Long id);
}
