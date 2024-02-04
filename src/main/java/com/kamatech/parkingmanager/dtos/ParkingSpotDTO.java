package com.kamatech.parkingmanager.dtos;

import jakarta.validation.constraints.NotBlank;

public class ParkingSpotDTO {

  @NotBlank
  private String parkingSpotNumber;
 @NotBlank
  private boolean isOccupied;

  public String getParkingSpotNumber() {
    return parkingSpotNumber;
  }

  public void setParkingSpotNumber(String parkingSpotNumber) {
    this.parkingSpotNumber = parkingSpotNumber;
  }

  public boolean isOccupied() {
    return isOccupied;
  }

  public void setOccupied(boolean occupied) {
    isOccupied = occupied;
  }
}
