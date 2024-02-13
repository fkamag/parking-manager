package com.kamatech.parkingmanager.services;

import com.kamatech.parkingmanager.dtos.ParkingSpotCreationDTO;
import com.kamatech.parkingmanager.models.ParkingSpotModel;
import com.kamatech.parkingmanager.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

  final ParkingSpotRepository parkingSpotRepository;

  @Autowired
  public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }

  @Transactional
  public ParkingSpotModel saveParkingSpot(ParkingSpotCreationDTO parkingSpotCreationDTO) {
    ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
    BeanUtils.copyProperties(parkingSpotCreationDTO, parkingSpotModel);
    UUID uuid = UUID.randomUUID();
    parkingSpotModel.setIdExternalParkingSpot(uuid);
    return parkingSpotRepository.save(parkingSpotModel);
  }

  public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
    return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
  }

  public List<ParkingSpotModel> getAllParkingSpot() {
    return parkingSpotRepository.findAll();
  }

}
