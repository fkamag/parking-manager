package com.kamatech.parkingmanager.dtos;

import java.util.UUID;

public record ParkingSpotDTO (
    Long idParkingSpot,
    UUID idExternalParkingSpot,
    String parkingSpotNumber,
    boolean isOccupied
) {

}
