package com.example.spacecatsmarketplace.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerDto {

    @Schema(description = "CosmoCat's name, must be non-blank and up to 50 characters.")
    @NotBlank(message = "Name is mandatory")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;

    @Schema(description = "CosmoCat's email address")
    @Email(message = "Email should be valid")
    private String email;
}