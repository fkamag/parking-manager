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
@Table(name = "TB_CAR")
public class CarModel implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCar;
  @Column(nullable = false, unique = true)
  private UUID idExternalCar;
  @Column(nullable = false, unique = true, length = 7)
  private String licensePlateCar;
  @Column(nullable = false, length = 70)
  private String brandCar;
  @Column(nullable = false, length = 70)
  private String modelCar;
  @Column(nullable = false, length = 70)
  private String colorCar;

  public Long getIdCar() {
    return idCar;
  }

  public void setIdCar(Long id_car) {
    this.idCar = id_car;
  }

  public String getLicensePlateCar() {
    return licensePlateCar;
  }

  public void setLicensePlateCar(String licensePlateCar) {
    this.licensePlateCar = licensePlateCar;
  }

  public String getBrandCar() {
    return brandCar;
  }

  public void setBrandCar(String brandCar) {
    this.brandCar = brandCar;
  }

  public String getModelCar() {
    return modelCar;
  }

  public void setModelCar(String modelCar) {
    this.modelCar = modelCar;
  }

  public String getColorCar() {
    return colorCar;
  }

  public void setColorCar(String colorCar) {
    this.colorCar = colorCar;
  }

  public UUID getIdExternalCar() {
    return idExternalCar;
  }

  public void setIdExternalCar(UUID idExternalCar) {
    this.idExternalCar = idExternalCar;
  }
}
