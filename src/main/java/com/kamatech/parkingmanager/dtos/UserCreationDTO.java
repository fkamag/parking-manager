package com.kamatech.parkingmanager.dtos;

import com.kamatech.parkingmanager.models.UserModel;

public record UserCreationDTO(
    String username,
    String password
) {

  public UserModel toEntity() {
    return new UserModel(null, username, password);
  }

}
