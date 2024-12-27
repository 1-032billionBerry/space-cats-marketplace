package com.example.spacecatsmarketplace.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.spacecatsmarketplace.domain.Product;
import com.example.spacecatsmarketplace.service.exception.ProductNotFoundException;
import com.example.spacecatsmarketplace.service.impl.ProductServiceImpl;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ProductServiceImpl.class})
class ProductServiceImplTest {

  @Autowired
  private ProductServiceImpl productService;

  private static final UUID PRODUCT_REFERENCE = UUID.fromString("00000000-0000-0000-0000-000000000001");

  @Test
  void testGetAllProducts() {
    List<Product> products = productService.getAllProducts();
    assertNotNull(products);
  }

  @Test
  void testGetProductByReference() {
    Product product = productService.getProductByReference(PRODUCT_REFERENCE);
    assertNotNull(product);
    assertEquals(PRODUCT_REFERENCE, product.getProductReference());
  }

  @Test
  void testGetProductByReference_NotFound() {
    assertThrows(ProductNotFoundException.class,
        () -> productService.getProductByReference(UUID.randomUUID()));
  }

  @Test
  void testCreateProduct() {
    Product newProduct = Product.builder()
        .productReference(PRODUCT_REFERENCE)
        .name("New Product")
        .build();
    Product createdProduct = productService.createProduct(newProduct);
    assertNotNull(createdProduct);
    assertEquals(PRODUCT_REFERENCE, createdProduct.getProductReference());
  }

  @Test
  void testUpdateProduct() {
    Product updatedProduct = Product.builder()
        .productReference(PRODUCT_REFERENCE)
        .name("Updated Product")
        .build();
    Product result = productService.updateProduct(updatedProduct);
    assertNotNull(result);
    assertEquals("Updated Product", result.getName());
    assertEquals(PRODUCT_REFERENCE, result.getProductReference());
  }

//  nothing to test here
//  @Test
//  void testDeleteProductByReference() {
//    productService.deleteProductByReference(PRODUCT_REFERENCE);
//  }
}
