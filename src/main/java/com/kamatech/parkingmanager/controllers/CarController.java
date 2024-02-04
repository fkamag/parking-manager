package com.kamatech.parkingmanager.controllers;

import com.kamatech.parkingmanager.dtos.CarDTO;
import com.kamatech.parkingmanager.models.CarModel;
import com.kamatech.parkingmanager.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/car")
public class CarController {

  final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @PostMapping
  public ResponseEntity<Object> saveCar(@RequestBody @Valid CarDTO carDTO) {
    var carModel = new CarModel();
    BeanUtils.copyProperties(carDTO, carModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(carModel));
  }
}
