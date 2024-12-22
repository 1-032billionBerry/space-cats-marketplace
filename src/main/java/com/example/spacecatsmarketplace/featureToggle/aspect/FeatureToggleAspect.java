package com.example.spacecatsmarketplace.featureToggle.aspect;

import com.example.spacecatsmarketplace.featureToggle.FeatureToggles;
import com.example.spacecatsmarketplace.featureToggle.annotation.FeatureToggle;
import com.example.spacecatsmarketplace.featureToggle.exception.FeatureToggleNotEnabledException;
import com.example.spacecatsmarketplace.featureToggle.service.FeatureToggleService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class FeatureToggleAspect {

  @Autowired
  private FeatureToggleService featureToggleService;

  @Before("@annotation(featureToggle)")
  public void checkFeatureToggleBefore(FeatureToggle featureToggle) {
    FeatureToggles toggle = featureToggle.value();
    if (!featureToggleService.check(toggle.getFeatureName())) {
      log.warn("Feature toggle {} is not enabled!", toggle.getFeatureName());
      throw new FeatureToggleNotEnabledException(toggle.getFeatureName());
    }
  }
}
