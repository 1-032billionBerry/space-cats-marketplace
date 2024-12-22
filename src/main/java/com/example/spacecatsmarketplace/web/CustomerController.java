package com.example.spacecatsmarketplace.web;

import com.example.spacecatsmarketplace.dto.CustomerDto;
import com.example.spacecatsmarketplace.featureToggle.FeatureToggles;
import com.example.spacecatsmarketplace.featureToggle.annotation.FeatureToggle;
import com.example.spacecatsmarketplace.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping
  @FeatureToggle(FeatureToggles.COSMO_CUSTOMERS)
  public ResponseEntity<List<CustomerDto>> getAllCustomers() {
    List<CustomerDto> customers = customerService.getCustomers();
    return ResponseEntity.ok(customers);
  }
}
