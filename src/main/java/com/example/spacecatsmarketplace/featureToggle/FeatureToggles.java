package com.example.spacecatsmarketplace.featureToggle;

import lombok.Getter;

@Getter
public enum FeatureToggles {
  COSMO_CUSTOMERS("cosmoCustomers"),
  ASTRONAUT_PRODUCTS("astronautProducts");

  private final String featureName;

  FeatureToggles(String featureName) {
    this.featureName = featureName;
  }
}
