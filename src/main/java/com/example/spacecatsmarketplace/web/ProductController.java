package com.example.spacecatsmarketplace.web;

import com.example.spacecatsmarketplace.domain.Product;
import com.example.spacecatsmarketplace.dto.ProductDto;
import com.example.spacecatsmarketplace.service.ProductService;
import com.example.spacecatsmarketplace.service.mapper.ProductMapper;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;
  private final ProductMapper productMapper;

  @GetMapping
  public ResponseEntity<List<ProductDto>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts().stream()
        .map(productMapper::toProductDto)
        .toList());
  }

  @GetMapping("{productReference}")
  public ResponseEntity<ProductDto> getProductById(@PathVariable UUID productReference) {
    return ResponseEntity.ok(productMapper.toProductDto(
        productService.getProductByReference(productReference)));
  }

  @PostMapping
  public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto productDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toProductDto(
        productService.createProduct(productMapper.toProduct(productDto))));
  }

  @PutMapping("{productReference}")
  public ResponseEntity<ProductDto> updateProduct(@PathVariable UUID productReference,
      @RequestBody ProductDto productDto) {
    Product product = productMapper.toProduct(productDto);
    product.setProductReference(productReference);
    return ResponseEntity.ok(productMapper.toProductDto(productService.updateProduct(product)));
  }

  @DeleteMapping("{productReference}")
  public ResponseEntity<Void> deleteProduct(@PathVariable UUID productReference) {
    productService.deleteProductByReference(productReference);
    return ResponseEntity.noContent().build();
  }
}
