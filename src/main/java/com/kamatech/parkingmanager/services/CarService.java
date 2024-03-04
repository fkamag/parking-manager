package com.kamatech.parkingmanager.services;

import com.kamatech.parkingmanager.models.CarModel;
import com.kamatech.parkingmanager.repositories.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  @Autowired
  private final CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @Transactional
  public CarModel save(CarModel carModel) {
    return carRepository.save(carModel);
  }
}
