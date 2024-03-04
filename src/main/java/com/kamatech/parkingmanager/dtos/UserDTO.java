package com.kamatech.parkingmanager.dtos;

public record UserDTO(
    Long id,
    String username,
    String password       // apenas em desenvolvimento, retirar em produção

) {

}
