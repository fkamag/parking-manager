package com.kamatech.parkingmanager.dtos;

import com.kamatech.parkingmanager.models.ParkingSpotModel;

public class ParkingSpotDtoMapper {

  public static ParkingSpotDTO ParkingSpotToDTO(ParkingSpotModel parkingSpot) {
    return new ParkingSpotDTO(
        parkingSpot.getIdParkingSpot(),
        parkingSpot.getIdExternalParkingSpot(),
        parkingSpot.getParkingSpotNumber(),
        parkingSpot.isOccupied()
    );
  }

}
