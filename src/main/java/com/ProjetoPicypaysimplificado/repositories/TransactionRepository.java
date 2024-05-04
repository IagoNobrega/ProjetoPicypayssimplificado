package com.ProjetoPicypaysimplificado.repositories; // Corrigido de "repositaries" para "repositories"

import com.ProjetoPicypaysimplificado.domain.transaction.Transaction; // Corrigido de "domin" para "domain"
import org.springframework.data.jpa.repository.JpaRepository; // Corrigido de "respository" para "repository"

public interface TransactionRepository extends JpaRepository<Transaction, Long > { // Corrigido de TransactionRespository para TransactionRepository
}
