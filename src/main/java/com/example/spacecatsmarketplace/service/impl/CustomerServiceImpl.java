package com.example.spacecatsmarketplace.service.impl;

import com.example.spacecatsmarketplace.dto.CustomerDto;
import com.example.spacecatsmarketplace.service.CustomerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public List<CustomerDto> getCustomers() {
    return List.of(
        CustomerDto.builder()
            .name("Astralis")
            .email("astralis2024@gmail.com")
            .build(),

        CustomerDto.builder()
            .name("Nova")
            .email("nova.starrysky@gmail.com")
            .build()

    );
  }
}
