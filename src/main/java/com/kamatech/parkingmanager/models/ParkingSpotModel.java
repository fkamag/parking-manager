package com.kamatech.parkingmanager.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idParkingSpot;
  @Column(nullable = false, unique = true)
  private UUID idExternalParkingSpot;
  @Column(nullable = false, unique = true, length = 10)
  private String parkingSpotNumber;
  @Column(nullable = false)
  private boolean isOccupied;

  public Long getIdParkingSpot() {
    return idParkingSpot;
  }

  public void setIdParkingSpot(Long id_parking_spot) {
    this.idParkingSpot = id_parking_spot;
  }

  public UUID getIdExternalParkingSpot() {
    return idExternalParkingSpot;
  }

  public void setIdExternalParkingSpot(UUID idExternalParkingSpot) {
    this.idExternalParkingSpot = idExternalParkingSpot;
  }

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
