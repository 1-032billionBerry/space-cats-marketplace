package com.example.spacecatsmarketplace.service;

import com.example.spacecatsmarketplace.dto.CustomerDto;
import java.util.List;

public interface CustomerService {

    List<CustomerDto> getCustomers();
}
