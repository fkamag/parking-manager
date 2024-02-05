package com.kamatech.parkingmanager.controllers;

import com.kamatech.parkingmanager.dtos.ParkingSpotDTO;
import com.kamatech.parkingmanager.models.ParkingSpotModel;
import com.kamatech.parkingmanager.services.ParkingSpotService;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
  final ParkingSpotService parkingSpotService;

  public ParkingSpotController(ParkingSpotService parkingSpotService) {
    this.parkingSpotService = parkingSpotService;
  }

  @PostMapping
  public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
    try {

      var parkingSpotModel = new ParkingSpotModel();
      BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
      UUID uuid = UUID.randomUUID();
      parkingSpotModel.setIdExternalParkingSpot(uuid);
      return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService
          .save(parkingSpotModel));

    } catch (DataIntegrityViolationException e) {
      // Tratar a exceção de violação de chave única aqui
      // Reverter a transação, se necessário
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
