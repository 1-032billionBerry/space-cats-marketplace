package com.example.spacecatsmarketplace.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryType {

  SPACE_CLOTHES("Space Clothes"),
  COSMOFOOD("Cosmofood"),
  GALAXY_BOOKS("Galaxy Books"),
  UNIVERSE_TOYS("Universe Toys"),
  ASTRONAUT_ELECTRONICS("Astronaut Electronics"),
  ORBIT_ACCESSORIES("Orbit Accessories");

  private final String displayName;
}
