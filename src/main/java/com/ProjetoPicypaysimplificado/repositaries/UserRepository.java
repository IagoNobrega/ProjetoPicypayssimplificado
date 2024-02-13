package com.ProjetoPicypaysimplificado.repositaries;

import com.ProjetoPicypaysimplificado.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository exetendsJpaRepository<User, Long>{
    Optional<User> findUserByDocument(String document);

    Optional<User> findUserByEmailId(Long id );
}
