package com.kamatech.parkingmanager.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CarDTO {

  @NotBlank
  @Size(max = 7)
  private String licensePlateCar;
  @NotBlank
  @Size(max = 70)
  private String brandCar;
  @NotBlank
  @Size(max = 70)
  private String modelCar;
  @NotBlank
  @Size(max = 70)
  private String colorCar;

}
