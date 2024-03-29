package com.kamatech.parkingmanager.repositories;

import com.kamatech.parkingmanager.models.UserModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

  Optional<UserModel> findByUsername(String username);

}
