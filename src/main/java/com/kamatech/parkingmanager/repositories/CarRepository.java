package com.kamatech.parkingmanager.repositories;

import com.kamatech.parkingmanager.models.CarModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarModel, UUID> {

}
