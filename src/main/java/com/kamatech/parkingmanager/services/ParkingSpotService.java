package com.kamatech.parkingmanager.services;

import com.kamatech.parkingmanager.models.ParkingSpotModel;
import com.kamatech.parkingmanager.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

  final ParkingSpotRepository parkingSpotRepository;

  public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }

  @Transactional
  public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
    return parkingSpotRepository.save(parkingSpotModel);
  }
}
