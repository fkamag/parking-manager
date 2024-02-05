package com.kamatech.parkingmanager.repositories;

import com.kamatech.parkingmanager.models.CarModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Long> {

}
