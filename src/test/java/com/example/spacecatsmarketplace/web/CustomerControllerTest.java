package com.example.spacecatsmarketplace.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.spacecatsmarketplace.dto.CustomerDto;
import com.example.spacecatsmarketplace.featureToggle.FeatureToggles;
import com.example.spacecatsmarketplace.featureToggle.aspect.FeatureToggleAspect;
import com.example.spacecatsmarketplace.featureToggle.service.FeatureToggleService;
import com.example.spacecatsmarketplace.service.CustomerService;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private FeatureToggleService featureToggleService;

  @TestConfiguration
  @EnableAspectJAutoProxy
  static class TestConfig {
    @Bean
    public FeatureToggleAspect featureToggleAspect() {
      return new FeatureToggleAspect();
    }
  }

  @Test
  void testGetCustomersWhenFeatureToggleIsEnabled() throws Exception {
    when(featureToggleService.check(FeatureToggles.COSMO_CUSTOMERS.getFeatureName())).thenReturn(true);
    List<CustomerDto> customers = Collections.singletonList(CustomerDto.builder().build());
    when(customerService.getCustomers()).thenReturn(customers);

    mockMvc.perform(get("/api/v1/customers")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0]").exists());
  }

  @Test
  void testGetCustomersWhenFeatureToggleIsDisabled() throws Exception {
    when(featureToggleService.check(FeatureToggles.COSMO_CUSTOMERS.getFeatureName())).thenReturn(false);

    System.out.println(featureToggleService.check(FeatureToggles.COSMO_CUSTOMERS.getFeatureName()));

    mockMvc.perform(get("/api/v1/customers")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }
}
