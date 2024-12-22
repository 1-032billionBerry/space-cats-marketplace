package com.example.spacecatsmarketplace.featureToggle.service;

import com.example.spacecatsmarketplace.featureToggle.config.FeatureToggleProperties;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class FeatureToggleService {

  private final ConcurrentHashMap<String, Boolean> featureToggles;

  public FeatureToggleService(FeatureToggleProperties featureToggleProperties) {
    featureToggles = new ConcurrentHashMap<>(featureToggleProperties.getToggles());
  }

  public boolean check(String featureName) {
    return featureToggles.getOrDefault(featureName, false);
  }
}
