package com.kamatech.parkingmanager.repositories;

import com.kamatech.parkingmanager.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, Long> {

  boolean existsByParkingSpotNumber(String parkingSpotNumber);

}

