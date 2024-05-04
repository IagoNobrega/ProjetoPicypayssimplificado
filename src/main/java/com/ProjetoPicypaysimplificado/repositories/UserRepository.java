package com.ProjetoPicypaysimplificado.repositories; // Corrigido de "respositaries" para "repositories"

import com.ProjetoPicypaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository; // Corrigido de "JpaRespository" para "JpaRepository"

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { // Corrigido de "UserRespository" para "UserRepository" e "JpaRespository" para "JpaRepository"
    Optional<User> findUserByDocument(String document); // Removido o espaço extra entre Optional e User
    Optional<User> findUserById(Long id); // Não foi necessário corrigir, pois já estava correto
}
