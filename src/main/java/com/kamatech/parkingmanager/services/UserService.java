package com.kamatech.parkingmanager.services;

import com.kamatech.parkingmanager.models.UserModel;
import com.kamatech.parkingmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
  @Autowired
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserModel create(UserModel userModel) {
    System.out.println("Acessando Service");


    String hashedPassword = new BCryptPasswordEncoder()
        .encode(userModel.getPassword());

    userModel.setPassword(hashedPassword);

    return userRepository.save(userModel);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));
  }
}
