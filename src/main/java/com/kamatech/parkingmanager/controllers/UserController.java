package com.kamatech.parkingmanager.controllers;

import com.kamatech.parkingmanager.dtos.UserCreationDTO;
import com.kamatech.parkingmanager.models.UserModel;
import com.kamatech.parkingmanager.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {
  @Autowired
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserCreationDTO userDTO) {
    System.out.println("Acessando controller");
    UserModel user = userService.create(userDTO.toEntity());

    return ResponseEntity.status(HttpStatus.CREATED).body(user);

  }


}
