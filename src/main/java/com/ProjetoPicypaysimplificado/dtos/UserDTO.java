package com.ProjetoPicypaysimplificado.dtos;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {
}

enum UserType {
    ADMIN,
    USER
}