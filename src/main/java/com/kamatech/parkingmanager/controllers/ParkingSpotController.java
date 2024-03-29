package com.kamatech.parkingmanager.controllers;

import static com.kamatech.parkingmanager.dtos.ParkingSpotDtoMapper.ParkingSpotToDTO;

import com.kamatech.parkingmanager.dtos.ParkingSpotCreationDTO;
import com.kamatech.parkingmanager.dtos.ParkingSpotDTO;
import com.kamatech.parkingmanager.models.ParkingSpotModel;
import com.kamatech.parkingmanager.services.ParkingSpotService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
  final ParkingSpotService parkingSpotService;

  @Autowired
  public ParkingSpotController(ParkingSpotService parkingSpotService) {
    this.parkingSpotService = parkingSpotService;
  }

  @PostMapping
  public ResponseEntity<String> saveParkingSpot(@RequestBody @Valid
  ParkingSpotCreationDTO parkingSpotCreationDTO) {
    try {
      if (parkingSpotService.existsByParkingSpotNumber(
          parkingSpotCreationDTO.parkingSpotNumber())) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body("A vaga %s já existe".formatted(
                parkingSpotCreationDTO.parkingSpotNumber()));
      }

      parkingSpotService.saveParkingSpot(parkingSpotCreationDTO);

      return ResponseEntity.status(HttpStatus.CREATED)
          .body("Vaga %s criada com sucesso".formatted(
              parkingSpotCreationDTO.parkingSpotNumber()));

    } catch (DataIntegrityViolationException e) {
      // Tratar a exceção de violação de chave única aqui
      // Reverter a transação, se necessário
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<List<ParkingSpotDTO>> getAllParkingSpot() {
    List<ParkingSpotDTO> parkingSpotDTOList = new ArrayList<>();
    for (ParkingSpotModel parkingSpot : parkingSpotService.getAllParkingSpot()) {
      parkingSpotDTOList.add(ParkingSpotToDTO(parkingSpot));
    }
    return ResponseEntity.status(HttpStatus.OK).body(parkingSpotDTOList);
  }
}
