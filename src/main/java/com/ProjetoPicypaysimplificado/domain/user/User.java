package com.ProjetoPicypaysimplificado.domain.user;



import jakarta.persitence.*;

import lombok.AllArgsConntructor;
import lombok.EqualsAndHashCode;
import lombok.@Getter;
import lombok.@Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConntructor
@EqualsAndHashCode(of ="id")


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fristName;
    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;  
}
