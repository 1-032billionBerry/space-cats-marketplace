package com.example.spacecatsmarketplace.service.mapper;

import com.example.spacecatsmarketplace.domain.Customer;
import com.example.spacecatsmarketplace.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    CustomerDto toCustomerDto(Customer customer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    Customer toCustomer(CustomerDto customerDto);
}